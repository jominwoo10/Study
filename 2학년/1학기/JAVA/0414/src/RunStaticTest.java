
public class RunStaticTest {

	public static void main(String[] args) {
		StaticTest s1 = new StaticTest();
		StaticTest s2 = new StaticTest();
		
		s1.ins = 5;
		s2.ins = 500;
		
		System.out.println("* s1.ins: " + s1.ins);
		System.out.println("* s2.ins: " + s2.ins);
		
		s1.stc = 7;
		s2.stc = 700;
		
		System.out.println("* s1.stc: " + StaticTest.stc);
		System.out.println("* s2.stc: " + s2.stc);
	}

}
