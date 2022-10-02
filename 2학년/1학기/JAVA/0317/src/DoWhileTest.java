import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("* 반복횟수 입력: ");
		int num = s.nextInt();
		
		int i = 0;
		do
		{
			System.out.println("do문은 무조건 실행됩니다.");
			i++;
		}while(i < num);
		s.close();
	}

}
