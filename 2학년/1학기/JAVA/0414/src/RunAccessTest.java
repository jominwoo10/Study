
public class RunAccessTest {

	public static void main(String[] args) {
		AccessTest at = new AccessTest();
		at.a = 100;
		at.setB(200);
		System.out.println("* AccessTest의 필드 a: " + at.a);
		System.out.println("* AccessTest의 필드 a: " + at.getB());
	}

}
