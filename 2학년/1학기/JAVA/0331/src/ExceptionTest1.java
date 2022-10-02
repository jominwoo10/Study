import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {

	public static void main(String[] args) {
		int n1 = 0;
		int n2 = 0;
		int result = 0;
		Scanner s1 = new Scanner(System.in);
		try
		{
			System.out.print("* 나누어지는 수(분자) 입력: ");
			n1 = s1.nextInt();
			System.out.print("* 나누는 수(분모) 입력: ");
			n2 = s1.nextInt();
	
			result = n1 / n2;
		}
		catch (ArithmeticException e)
		{
			System.out.println("!!! 정수는 0으로 나누면 안됩니다.");
			System.out.println("프로그램을 다시 실행해 주세요~");
			
			System.out.print("* 나누어지는 수(분자) 입력: ");
			n1 = s1.nextInt();
			System.out.print("* 나누는 수(분모) 입력: ");
			n2 = s1.nextInt();
			result = n1 / n2;
		}
		catch (InputMismatchException e) 
		{
			System.out.println("* 반드시 정수값을 입력해 주세요");
			System.out.println("프로그램을 다시 실행해 주세요~");
			return;
		}
		
		System.out.printf("%d ÷ %d = %d", n1, n2, result);
		
		s1.close();
		
	}

}
