import java.util.Scanner;

public class ArrayTest2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		String[] subject = {"����","����","����","����","����"};
		int[][] score = new int[2][subject.length];
		String[] name = new String[score.length]; 
		int sum[] = new int[score.length];
		double avg[] = new double[score.length];
		
		for (int i = 0; i < score.length; i++) 
		{
			System.out.printf("* ���� �Է�: ");
			name[i] = s2.next();
			System.out.printf("* [%s]�� �����Է� *\n",name[i]);
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
			System.out.printf("===== %s���� ���� ��� =====\n",name[i]);
			for (int j = 0; j < score[i].length; j++) 
			{
				System.out.printf("%s( %d�� )\t",subject[j],score[i][j]);
			}
			System.out.println();
			System.out.printf("* ���� = %d, ��� = %.2f",sum[i], avg[i]);
			System.out.println("\n");
			
		}
		s.close();
		s2.close();
	}

}
