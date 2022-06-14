// TextToCsvFile 클래스를 사용하세요라는 주석을 적어줘야 사용하는 입장에서
// 재정의하지않고 찾아서 편리하게 사용할 수 있다.
//  구현체를 적어놓지도 않고 구현체의 이름을 인터페이스와 비슷하게 만들어놓지 않으면
// 직접 찾기는 불가능하다.
// 구현체 : TxtToCsvFile
public interface TxtToCsvFileable {
    // abstract public은 생략해도 붙어있다
    abstract public int process(String readFilePath, String writeFilePath);
}
