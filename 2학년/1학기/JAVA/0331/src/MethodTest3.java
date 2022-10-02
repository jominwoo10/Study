import java.util.Scanner;

public class MethodTest3 {

	public static void add(int n1, int n2)
	{
		int result = n1 + n2;
		System.out.printf("%d + %d = %d\n", n1, n2, result);
	}
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in); //숫자 입력 스캐너
		Scanner s2 = new Scanner(System.in); //문자열 입력 스캐너(yes/no)
		System.out.println("================= 두 수 더하기 =================");
		while(true)
		{
			System.out.print("* 정수 1 입력:");
			int n1 = s1.nextInt();
			
			System.out.print("* 정수 2 입력:");
			int n2 = s1.nextInt();
			
			add(n1, n2);
			
			System.out.print("* 계속하시겠습니까?(yes/no):");
			String conti = s2.next();
			if(conti.equals("no"))
					break;
		}
		s1.close();
		s2.close();

	}

}
