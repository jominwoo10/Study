import java.util.Scanner;

public class ArrayTest2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		String[] subject = {"국어","영어","수학","과학","역사"};
		int[][] score = new int[2][subject.length];
		String[] name = new String[score.length]; 
		int sum[] = new int[score.length];
		double avg[] = new double[score.length];
		
		for (int i = 0; i < score.length; i++) 
		{
			System.out.printf("* 성명 입력: ");
			name[i] = s2.next();
			System.out.printf("* [%s]의 성적입력 *\n",name[i]);
			for (int j = 0; j < score[i].length; j++) 
			{
				System.out.printf("%s :",subject[j]);
				score[i][j] = s.nextInt();
				sum[i] += score[i][j];
			}
			avg[i] = (double)sum[i] / subject.length;
		}
		
		for (int i = 0; i < score.length; i++) 
		{
			System.out.printf("===== %s님의 성적 출력 =====\n",name[i]);
			for (int j = 0; j < score[i].length; j++) 
			{
				System.out.printf("%s( %d점 )\t",subject[j],score[i][j]);
			}
			System.out.println();
			System.out.printf("* 총점 = %d, 평균 = %.2f",sum[i], avg[i]);
			System.out.println("\n");
			
		}
		s.close();
		s2.close();
	}

}
