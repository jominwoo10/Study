import java.util.Scanner;

public class ifTest {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		System.out.println("* 성명 입력: ");
		String name = s1.nextLine();
		System.out.println("* Java 프로그래밍 성적 입력: ");
		int score = s2.nextInt();
		
		if(score >= 90)
			System.out.println("아주 우수한 성적을 받으셨네요~");
		else
			System.out.println("조금만 더 노력하면 좋은 성적을 받을 수 있어요~");
		
		System.out.printf("%s학생의 Java 성적은 %d점입니다.",name, score);
		
		s1.close();
		s2.close();	
	}

}
