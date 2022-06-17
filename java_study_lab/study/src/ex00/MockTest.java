package ex00;

// Object = 실체화(인스턴스화 = new가 되나?)가 가능해야함.
// object는 실체화 될 가능성이 있는 것 인스턴스는 실체화 된것 class는 오브젝트의 설계도
abstract class 요리사{
	abstract public void 요리하다(); // 오버라이드가 된 것
}

// 요리사
class 임꺽정 extends 요리사{
	public void 요리하다() { // 재정의 된 것
		System.out.println("요리");
	}
}

// 사장
class 장보고{
	// 컴포지션(DI)
	요리사 p1;
	
	public 장보고(요리사 p1) {
		this.p1 = p1;
	}
	public void 계산() {
		System.out.println("계산");
	}
}

class Mock임꺽정 extends 요리사{

	@Override
	public void 요리하다() {
		// 가짜니까 굳이 내용이 필요하지 않다
		// stub을 해주게 되면 내용을 채워주는것이다.
	}
	
}

public class MockTest {
	public static void main(String[] args) {
//		요리사 p = new 임꺽정();
//		장보고 s = new 장보고(p);
//		s.p1.요리하다();
		
		장보고 s = new 장보고(new Mock임꺽정());
	}
}
