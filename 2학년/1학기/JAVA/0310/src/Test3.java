import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("1. 주소 입력: ");
		String s1 = s.nextLine();
		
		System.out.println("2. 이름 입력: ");
		String s2 = s.next();
		
		String s3, s4, s5;
		System.out.println("3. 존경하는 위인 3명을 입력: ");
		s3 = s.next();
		s4 = s.next();
		s5 = s.next();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.printf("존경하는 위인들은 %s, %s, %s입니다.", s3, s4, s5);
	}

}
