import java.util.Scanner;

public class ifTest {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		System.out.println("* ���� �Է�: ");
		String name = s1.nextLine();
		System.out.println("* Java ���α׷��� ���� �Է�: ");
		int score = s2.nextInt();
		
		if(score >= 90)
			System.out.println("���� ����� ������ �����̳׿�~");
		else
			System.out.println("���ݸ� �� ����ϸ� ���� ������ ���� �� �־��~");
		
		System.out.printf("%s�л��� Java ������ %d���Դϴ�.",name, score);
		
		s1.close();
		s2.close();	
	}

}
