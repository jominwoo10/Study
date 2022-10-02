package pack1;

// 클래스의 접근지정자 
// public : 모든 패키지에서 접근 가능하다
// default(생략) : 같은 패키지에서만 접근이 가능하다
public class Base {
	public int a;
	private int b;
	protected int c;
	int d;
	
	public void test1() {
		System.out.println("test1() 호출");
		b = 500;
	}
}
