import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("* �ݺ�Ƚ�� �Է�: ");
		int num = s.nextInt();
		
		int i = 0;
		do
		{
			System.out.println("do���� ������ ����˴ϴ�.");
			i++;
		}while(i < num);
		s.close();
	}

}
