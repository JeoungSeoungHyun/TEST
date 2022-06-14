public class App3 {

    public static void CSVFileCreate(TxtToCsvFile ttc) {
        ttc.process("zipcode.txt", "zipcode3.csv");
    }
    // public static void CSVFileCreate(TxtToCsvFileable ttc) {
    // ttc.process("zipcode.txt", "zipcode3.csv");
    // }

    public static void main(String[] args) {
        // 인터페이스를 띄우기 때문에 process만 접근가능하다.
        // TxtToCsvFileable ta = new TxtToCsv();
        // ta.process("zipcode.txt", "zipcode2.csv");
    }
}
