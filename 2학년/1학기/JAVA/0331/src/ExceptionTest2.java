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
				System.out.print("* 정수 "+ (i+1) +" 입력: ");
				nums[i] = s1.nextInt();
			}
		
			System.out.print("* 확인하고 싶은 인덱스 번호를 입력: ");
			int n = s1.nextInt();
			
			System.out.printf("nums[%d]의 값은 %d입니다.\n", n, nums[n]);
		}
		catch (InputMismatchException e)
		{
			System.out.println("!!! 정수만 입력하세요");
			System.out.println("처음부터 다시 입력해 주세요!");
			
			for (int i = 0; i < nums.length; i++) 
			{
				System.out.print("* 정수 "+ (i+1) +" 입력: ");
				nums[i] = s2.nextInt();
			}
		
			
			System.out.print("* 확인하고 싶은 인덱스 번호를 입력: ");
			int n = s2.nextInt();
			
			System.out.printf("nums[%d]의 값은 %d입니다.\n", n, nums[n]);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("!!! 배열의 인덱스 번호가 범위를 벗어났습니다.");
			System.out.println("* 확인하고 싶은 인덱스 번호를 입력: ");
			
			int n = s2.nextInt();
			System.out.printf("nums[%d]의 값은 %d입니다.\n", n, nums[n]);
		}
		s1.close();
		s2.close();
	}

}
