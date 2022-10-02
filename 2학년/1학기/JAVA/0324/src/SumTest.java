import java.util.Scanner;

public class SumTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		while(true)
		{
			System.out.print("* 합계를 구할 마지막 정수 입력: ");
			int num = s.nextInt();
			int sum = 0;
			
			for(int i=0; i < num; i++)
			{
				sum += i+1; // sum = sum +(i+1)
			}
			
			System.out.printf("1부터 %d까지의 합계는 %d 입니다.\n", num, sum);
			System.out.print("* 계속해서 합계를 구하시겠습니까? (yes/no): ");
			String answer = s2.nextLine();
			if(answer.equals("no"))
				break;
		}
		
		s.close();
		s2.close();
		
		}

}
