
public class DataTypeTest {

	public static void main(String[] args) {
		byte b = 127;
		short s = b;//������(�ڵ�)����ȯ
		int i = s;//������(�ڵ�)����ȯ
		long l = b;//������(�ڵ�)����ȯ
		
		float f = 100;
		f = 1;
		f = 55.77F;//����� ����ȯ
		f = (float)77.11;//����� ����ȯ
		
		double d = 100000;
		d = 127;
//		d = 688.123;
	//	d = f;
		
		
		System.out.println("d = " + d);
		
		char c = 'a';
		c = 66;//������ ����ȯ
		
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
