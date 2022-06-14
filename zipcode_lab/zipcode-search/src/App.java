public class App {

    public static void main(String[] args) {
        String readFilePath = "zipcode.txt";
        String writeFilePath = "zipcode.csv";

        TxtToCsvFile ttc = new TxtToCsvFile();

        // int result = ttc.process(readFilePath, writeFilePath);

        // if (result == 1) {
        // System.out.println("파일 생성에 성공하였습니다.");
        // } else {
        // System.out.println("파일 생성에 실패하였습니다.");
        // }

        // // 내 워크스페이스 경로 찾는 코드 => 메서드화 + 오버로딩까지 해보기
        try {
            String rootPath = System.getProperty("user.dir");
            System.out.println("현재 프로젝트의 경로 : " + rootPath);
            int index = rootPath.indexOf("\\");
            while (index != -1) {
                index = rootPath.indexOf("\\", index + 2);
                // rootPath.insert(index + 1, "\\\\");
                System.out.println("index : " + index);
            }
        } catch (

        Exception e) {
            e.printStackTrace();
        }

        // // 이렇게 사용하는 경우에는 path를 풀경로일지 뭐일지 모르 때문에 문서를 만들어서 알려준다.
        // // 혹은 메서드에 간단한 주석
        // String addrData = readFile(readPath, encType);
        // // System.out.println(addrData);

        // String addrCsv = changeCsv(addrData, "^");
        // // System.out.println(addrCsv);

        // writeFile(writePath, encType, addrCsv);
    }
}
