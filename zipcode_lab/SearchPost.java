import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchPost {
    public static void main(String[] args) {
        // 입력을 받기 위한 sacnner
        Scanner sc = new Scanner(System.in);

        // 파일을 쓰기 위한 bufferedwriter
        BufferedWriter bw = null;
        try {
            // while문을 끝내기 위한 int 변수
            int exit = 1;

            // 파일을 쓰기 위한 csv파일의 경로
            File csv = new File("C:\\green_workspace\\downloads\\mytest.csv");
            bw = new BufferedWriter(new FileWriter(csv));

            // oracle DB 연결 (라이브러리 사용을 하기 떄문에 빌드패스가 필요하다.)
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");

            while (exit != 0) {
                System.out.println("=========================");
                System.out.println("종료하려면 0을 입력하세요");

                String str = sc.nextLine();
                if (str.equals("0")) {
                    exit = 0;
                }

                System.out.println("입력값 : " + str);
                System.out.println("===============================================");

                // 쿼리를 수행
                String sql = "SELECT 우편번호,기관,전화번호,번호,지역 FROM post WHERE 기관 LIKE ? or 지역 LIKE ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // %?%의 형태로는 동적바인딩이 되지 않지만 아래와 같이 넣어주면 바인딩이 된다.
                pstmt.setString(1, "%" + str + "%");
                pstmt.setString(2, "%" + str + "%");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String 우편번호 = rs.getString("우편번호");
                    String 기관 = rs.getString("기관");
                    String 전화번호 = rs.getString("전화번호");
                    String 번호 = rs.getString("번호");
                    String 지역 = rs.getString("지역");

                    // csv 파일로 쓰기 위해 ,를 넣은 스트링 형태를 만들어준다.
                    String row = 우편번호 + "," + 기관 + "," + 전화번호 + "," + 번호 + "," + 지역;

                    bw.write(row);
                    bw.newLine();
                }
                if (bw != null) {
                    bw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
