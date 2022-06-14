import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReadTest {
    public static void main(String[] args) throws Exception {
        File doc = new File("C:\\green_workspace\\downloads\\zipoffice.txt");
        // utf-8로 인코딩을 안해야 한글이나오네...
        BufferedReader br = new BufferedReader(new FileReader(doc));

        int count = 0;
        StringBuffer sb = new StringBuffer();
        while (br.readLine() != null) {
            if (br.readLine() == null) {
                System.out.println("이거 맞냐");
                break;
            }
            count += 1;
            String str = br.readLine();
            // replaceall은 정규표현식을 사용해서 \\를 붙여줘야 하는 특수문자가 존재한다.
            // replace는 charsequence
            String parseStr = str.replace("^", ",");
            sb.append(parseStr);
            sb.append("\n");
        }
        System.out.println(sb);
        System.out.println(count);
    }
}