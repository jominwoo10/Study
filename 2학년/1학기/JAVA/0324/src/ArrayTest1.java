import java.util.Scanner;

public class ArrayTest1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] score = new int[5];
		int sum = 0;
		
		for (int i = 0; i < score.length; i++) 
		{
			System.out.printf("* ���� %d �Է�: ",i+1);
			score[i] = s.nextInt();
			sum += score[i];
		}
		
		double avg = (double)sum / score.length;
		
		for (int i = 0; i < score.length; i++) 
		{
			System.out.printf("���� %d(%d��)\t", i+1, score[i]);
		}
		System.out.println();
		System.out.printf("* ����: %d, ���: %.2f", sum, avg);
		
		s.close();
	}

}
