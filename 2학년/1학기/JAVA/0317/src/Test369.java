import java.util.Scanner;

public class Test369 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("* ������ ���� ���� �Է�: ");
		int num = s.nextInt();
		
		if(num > 100)
		{
			System.out.println("�Է� ���ڴ� 100 ���Ͽ��� �մϴ�.");
		}
		else if((num % 10) % 3 == 0 || ((num / 10) % 3 == 0))
		{
			if((num % 10 == 0) && (num / 10) % 3 != 0)
				System.out.println(num);
			else
				System.out.println("�ڼ� ¦!");
		}
		else
		{
			System.out.println(num);
		}
		
		s.close();
	}

}
