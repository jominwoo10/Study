import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		int[] nums = new int[5];
		
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		try
		{
			for (int i = 0; i < nums.length; i++) 
			{
				System.out.print("* ���� "+ (i+1) +" �Է�: ");
				nums[i] = s1.nextInt();
			}
		
			System.out.print("* Ȯ���ϰ� ���� �ε��� ��ȣ�� �Է�: ");
			int n = s1.nextInt();
			
			System.out.printf("nums[%d]�� ���� %d�Դϴ�.\n", n, nums[n]);
		}
		catch (InputMismatchException e)
		{
			System.out.println("!!! ������ �Է��ϼ���");
			System.out.println("ó������ �ٽ� �Է��� �ּ���!");
			
			for (int i = 0; i < nums.length; i++) 
			{
				System.out.print("* ���� "+ (i+1) +" �Է�: ");
				nums[i] = s2.nextInt();
			}
		
			
			System.out.print("* Ȯ���ϰ� ���� �ε��� ��ȣ�� �Է�: ");
			int n = s2.nextInt();
			
			System.out.printf("nums[%d]�� ���� %d�Դϴ�.\n", n, nums[n]);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("!!! �迭�� �ε��� ��ȣ�� ������ ������ϴ�.");
			System.out.println("* Ȯ���ϰ� ���� �ε��� ��ȣ�� �Է�: ");
			
			int n = s2.nextInt();
			System.out.printf("nums[%d]�� ���� %d�Դϴ�.\n", n, nums[n]);
		}
		s1.close();
		s2.close();
	}

}
