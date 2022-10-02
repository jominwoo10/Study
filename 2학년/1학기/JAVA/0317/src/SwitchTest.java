import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("* 1 ~ 7 사이의 숫자를 입력하세요: ");
		int num = s.nextInt();
		String day = null;
		
		switch(num)
		{
		case 1:
			day = "일";
			break;
		case 2:
			day = "월";
			break;
		case 3:
			day = "화";
			break;
		case 4:
			day = "수";
			break;
		case 5:
			day = "목";
			break;
		case 6:
			day = "금";
			break;
		case 7:
			day = "토";
			break;
		default:
			System.out.println("1 ~ 7 사이의 숫자가 입력되지 않았습니다.");
			s.close();
			return;
		}
		
		System.out.println("당신이 선택한 숫자는" + day + "요일입니다.");
		
		s.close();
	}

}
