import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("1. �ּ� �Է�: ");
		String s1 = s.nextLine();
		
		System.out.println("2. �̸� �Է�: ");
		String s2 = s.next();
		
		String s3, s4, s5;
		System.out.println("3. �����ϴ� ���� 3���� �Է�: ");
		s3 = s.next();
		s4 = s.next();
		s5 = s.next();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.printf("�����ϴ� ���ε��� %s, %s, %s�Դϴ�.", s3, s4, s5);
	}

}
