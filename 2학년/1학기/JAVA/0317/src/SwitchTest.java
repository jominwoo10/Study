import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("* 1 ~ 7 ������ ���ڸ� �Է��ϼ���: ");
		int num = s.nextInt();
		String day = null;
		
		switch(num)
		{
		case 1:
			day = "��";
			break;
		case 2:
			day = "��";
			break;
		case 3:
			day = "ȭ";
			break;
		case 4:
			day = "��";
			break;
		case 5:
			day = "��";
			break;
		case 6:
			day = "��";
			break;
		case 7:
			day = "��";
			break;
		default:
			System.out.println("1 ~ 7 ������ ���ڰ� �Էµ��� �ʾҽ��ϴ�.");
			s.close();
			return;
		}
		
		System.out.println("����� ������ ���ڴ�" + day + "�����Դϴ�.");
		
		s.close();
	}

}
