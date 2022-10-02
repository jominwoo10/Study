
public class DataTypeTest {

	public static void main(String[] args) {
		byte b = 127;
		short s = b;//묵시적(자동)형변환
		int i = s;//묵시적(자동)형변환
		long l = b;//묵시적(자동)형변환
		
		float f = 100;
		f = 1;
		f = 55.77F;//명시적 형변환
		f = (float)77.11;//명시적 형변환
		
		double d = 100000;
		d = 127;
//		d = 688.123;
	//	d = f;
		
		
		System.out.println("d = " + d);
		
		char c = 'a';
		c = 66;//묵시적 형변환
		
		System.out.println("c = " + c);
		System.out.println("c = " + c+3);
		System.out.println("c = " + (c+3));
		System.out.println("c = " + (char)(c+3));
		
		boolean bb = true;
		bb = false;
		bb= s > b;
		
		System.out.println("bb = " + bb);
		
	}

}
