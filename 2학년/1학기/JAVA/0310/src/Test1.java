
public class Test1 {

	public static void main(String[] args) {
		int a= 3;
		int b =9;
		int min = 0;
		
		min = a < b ? a : b;
		
//		int min = 0;
//		if (a < b)
//			min = a;
//		else
//			min = b;
		
		System.out.printf("%d와 %d중에서 작은수는 %d입니다",a,b,min);
		System.out.println();
	}

}
