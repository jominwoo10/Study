import java.util.Scanner;

public class BMITest {

	public static void main(String[] args) {
		System.out.println("======= BMI =======");
		Scanner s = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("* 체중(㎏) 입력: ");
			double weight = s.nextDouble();
			System.out.print("* 키(㎝) 입력: ");
			double height = s.nextDouble();
			
			double bmi = weight / Math.pow(height/100, 2);
			
			System.out.printf("홍길동님의 BMI 지수는 %.2f(㎏/㎡)입니다.\n", bmi);
			
			String result ="";
			
			if(bmi < 18.5)
				result = "저";
			else if(bmi < 22.9)
				result = "정상";
			else if(bmi < 24.9)
				result = "과";
			else if(bmi < 29.9)
				result = "경도비만";
			else if(bmi < 39.9)
				result = "비만";
			else
				result = "고도비만";
			
			System.out.println("홍길동님은 "+ result +"체중입니다.");
			
			System.out.print("* 프로그램을 계속 사용하시겠습니까 ?(yes/no)");
			String use = s2.nextLine();
			if(use.equals("no"))
				break;
		}
		
		s.close();
		s2.close();
	}

}
