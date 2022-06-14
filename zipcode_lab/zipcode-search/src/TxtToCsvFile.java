import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;

public class TxtToCsvFile implements TxtToCsvFileable {
    // 인터페이스 변수는 static 변수이다?
    // 수정되지 않도록 final 상수로!!
    // 메서드를 이용하여 파싱하여 오버로딩 하여서 또 환경마다 사용할수있도록
    private final static String WORKSPACE = "C:\\green_workspace\\test\\zipcode\\zipcode-search\\";
    private final static String RESOURCE = WORKSPACE + "resource\\";

    // path = 내프로젝트경로와 내부 resource 폴더가 내장되어 있습니다.
    // encType = UTF-8, EUC-KR등을 입력해주면 됩니다.

    // String으로 리턴하는 경우 파싱이 제대로 되지 않기 때문에 StringBuilder자체를 리턴해줘야한다.
    // 혹은 append할 때 줄바꿈을 해주면 된다.
    protected String readFile(String path, String encType) {
        try {
            FileReader reader = new FileReader(RESOURCE + path, Charset.forName(encType));
            BufferedReader br = new BufferedReader(reader);

            String str;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str + "\n");
            }
            reader.close();
            br.close();
            return sb.toString();
        } catch (Exception e) {
            System.out.println("파일 경로가 잘못되었습니다.");
        }
        // catch가 발생할 경우에 return
        return null;
    }

    // path = 내프로젝트경로와 내부 resource 폴더가 내장되어 있습니다.
    // encType = UTF-8, EUC-KR등을 입력해주면 됩니다.
    // 내부를 까보게 되는건 캡슐화가 제대로 되지 않았다는 것이다.
    protected int writeFile(String path, String encType, String csvStr) {
        try {
            FileWriter writer = new FileWriter(RESOURCE + path, Charset.forName(encType));
            BufferedWriter bw = new BufferedWriter(writer);

            StringBuilder sb = new StringBuilder();
            writer.append(csvStr);
            writer.flush();
            bw.close();
            return 1;
        } catch (Exception e) {
            System.out.println("파일 쓰기에 실패하였습니다. 이유 : " + e.getMessage());
        }
        return -1;
    }

    protected String changeCsv(String data, String gubun) {
        // 지역변수를 만들면 byte가 할당되기 때문에 바로 리턴해주는것이 좋다.
        String addrCsv = data.replaceAll("\\" + gubun, ",");
        return addrCsv;
    }

    // 각 메서드는 private하게 하고 public으로 프로세스 메서드를 열어서 클라이언트들이
    // 사용하는데 혼란스럽지 않게 해준다. 하지만 각각의 메서드를 사용하고 싶은경우
    // interface를 implement하면 오버라이드 되는것
    public int process(String readFilePath, String writeFilePath) {
        TxtToCsvFile ttc = new TxtToCsvFile();
        String data = ttc.readFile(readFilePath, "UTF-8");
        String csvStr = ttc.changeCsv(data, "^");
        return ttc.writeFile(writeFilePath, "UTF-8", csvStr);
    }
}
