import java.util.Scanner;

public class MethodTest4 {

	public static int add(int n1, int n2)
	{
		int result = n1 + n2;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.print("* 정수 1 입력:");
		int n1 = s1.nextInt();
		System.out.print("* 정수 2 입력:");
		int n2 = s1.nextInt();
		int result = add(n1,n2);
		System.out.printf("%d + %d = %d\n",n1, n2, result);
		
		s1.close();
	}

}
