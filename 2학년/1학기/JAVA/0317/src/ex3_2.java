import java.util.Scanner;

public class ex3_2 {

	public static void main(String[] args) {
		int jumsu;
		
		Scanner s = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		jumsu = s.nextInt();
		
		if(jumsu >= 90)
			System.out.println("당신의 점수 "+ jumsu +"점의 해당하는 학점은 A 입니다.");
		else if(jumsu >= 80)
			System.out.println("당신의 점수 "+ jumsu +"점의 해당하는 학점은 B 입니다.");
		else if(jumsu >= 70)
			System.out.println("당신의 점수 "+ jumsu +"점의 해당하는 학점은 C 입니다.");
		else if(jumsu >= 60)
			System.out.println("당신의 점수 "+ jumsu +"점의 해당하는 학점은 D 입니다.");
		else
			System.out.println("당신의 점수 "+ jumsu +"점의 해당하는 학점은 F 입니다.");
		
		s.close();
		
	}

}
