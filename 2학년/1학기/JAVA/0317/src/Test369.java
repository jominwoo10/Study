import java.util.Scanner;

public class Test369 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("* 임의의 정수 값을 입력: ");
		int num = s.nextInt();
		
		if(num > 100)
		{
			System.out.println("입력 숫자는 100 이하여야 합니다.");
		}
		else if((num % 10) % 3 == 0 || ((num / 10) % 3 == 0))
		{
			if((num % 10 == 0) && (num / 10) % 3 != 0)
				System.out.println(num);
			else
				System.out.println("박수 짝!");
		}
		else
		{
			System.out.println(num);
		}
		
		s.close();
	}

}
