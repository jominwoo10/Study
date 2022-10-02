import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("* 나이 입력");
		int age = s.nextInt();
		
		String result = age > 20 ? "성인" : "미성년";
		
		System.out.println("당신은 " + result + "입니다");
	}

}
