public class App2 extends TxtToCsvFile {

    // 이 경우에는 부모메서드를 통해 동적바인딩으로 오버라이드 하는것이 아닌
    // 단순 메서드를 재정의하는것이다.
    // 2번째 방법?
    @Override
    public int process(String readFilePath, String writeFilePath) {
        TxtToCsvFile ttc = new TxtToCsvFile();
        String data = ttc.readFile(readFilePath, "UTF-8");
        String csvStr = ttc.changeCsv(data, "-");
        return ttc.writeFile(writeFilePath, "UTF-8", csvStr);
    }

    public static void main(String[] args) {
        App2 app2 = new App2();
        // App2.readFile(path, encType);
    }

}
