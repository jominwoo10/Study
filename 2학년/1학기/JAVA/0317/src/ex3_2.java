import java.util.Scanner;

public class ex3_2 {

	public static void main(String[] args) {
		int jumsu;
		
		Scanner s = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		jumsu = s.nextInt();
		
		if(jumsu >= 90)
			System.out.println("����� ���� "+ jumsu +"���� �ش��ϴ� ������ A �Դϴ�.");
		else if(jumsu >= 80)
			System.out.println("����� ���� "+ jumsu +"���� �ش��ϴ� ������ B �Դϴ�.");
		else if(jumsu >= 70)
			System.out.println("����� ���� "+ jumsu +"���� �ش��ϴ� ������ C �Դϴ�.");
		else if(jumsu >= 60)
			System.out.println("����� ���� "+ jumsu +"���� �ش��ϴ� ������ D �Դϴ�.");
		else
			System.out.println("����� ���� "+ jumsu +"���� �ش��ϴ� ������ F �Դϴ�.");
		
		s.close();
		
	}

}
