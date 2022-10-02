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
			System.out.print("* ���������� ��(����) �Է�: ");
			n1 = s1.nextInt();
			System.out.print("* ������ ��(�и�) �Է�: ");
			n2 = s1.nextInt();
	
			result = n1 / n2;
		}
		catch (ArithmeticException e)
		{
			System.out.println("!!! ������ 0���� ������ �ȵ˴ϴ�.");
			System.out.println("���α׷��� �ٽ� ������ �ּ���~");
			
			System.out.print("* ���������� ��(����) �Է�: ");
			n1 = s1.nextInt();
			System.out.print("* ������ ��(�и�) �Է�: ");
			n2 = s1.nextInt();
			result = n1 / n2;
		}
		catch (InputMismatchException e) 
		{
			System.out.println("* �ݵ�� �������� �Է��� �ּ���");
			System.out.println("���α׷��� �ٽ� ������ �ּ���~");
			return;
		}
		
		System.out.printf("%d �� %d = %d", n1, n2, result);
		
		s1.close();
		
	}

}
