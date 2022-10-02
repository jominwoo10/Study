import java.util.Scanner;

public class BMITest {

	public static void main(String[] args) {
		System.out.println("======= BMI =======");
		Scanner s = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("* ü��(��) �Է�: ");
			double weight = s.nextDouble();
			System.out.print("* Ű(��) �Է�: ");
			double height = s.nextDouble();
			
			double bmi = weight / Math.pow(height/100, 2);
			
			System.out.printf("ȫ�浿���� BMI ������ %.2f(��/��)�Դϴ�.\n", bmi);
			
			String result ="";
			
			if(bmi < 18.5)
				result = "��";
			else if(bmi < 22.9)
				result = "����";
			else if(bmi < 24.9)
				result = "��";
			else if(bmi < 29.9)
				result = "�浵��";
			else if(bmi < 39.9)
				result = "��";
			else
				result = "����";
			
			System.out.println("ȫ�浿���� "+ result +"ü���Դϴ�.");
			
			System.out.print("* ���α׷��� ��� ����Ͻðڽ��ϱ� ?(yes/no)");
			String use = s2.nextLine();
			if(use.equals("no"))
				break;
		}
		
		s.close();
		s2.close();
	}

}
