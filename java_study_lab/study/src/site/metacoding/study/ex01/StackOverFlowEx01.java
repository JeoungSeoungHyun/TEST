package site.metacoding.study.ex01;

// 클래스는 상태와 행위를 가지게 된다.
// 상태가 있는데 행위는 있을 수 있지만 행위가 있는데 상태가 없을수는 없다.
// Lion을 new할 책임은 누구도 없으니 메인에서 new한다.
// 따라서 모든것의 시작은 main 따라서 main은 모든것의 context를 가지게 된다.
class Lion{
	// static으로 만들 수 없다.(사자보다 배고픔이 먼저뜰수없다)
	// 아무나 외부에서 상태를 변경할 수 없도록 private하게 만든다.
	private int 배상태 = 0;
	
	public int get배상태() {
		return 배상태;
	}
	
	
	public void eat() {
		
		
		// 메서드가 들고있는 변수는 상태가 아니다.
		int happy = 0; // happy 변수를 위해 4byte 공간 필요
		배상태++;
		happy = happy + 10;
		if(배상태 >= 100) {
			
		} else {
			eat(); // 자기가 자신을 호출하는 것 재귀 메서드
		}
	}
}

// stack은 행위가 시작될 때 메모리 뜨는 것
// heap은 시작시부터 종료까지
// static은 첨부터 끝까지(
// heap, stack, static(클래스종속 키워드)
public class StackOverFlowEx01 {
	public static void main(String[] args) {
		Lion lion = new Lion();
		lion.eat();		
		System.out.println("아 배불러 : " + lion.get배상태());
	}
}
