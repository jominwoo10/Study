import java.util.Scanner;

public class MethodTest3 {

	public static void add(int n1, int n2)
	{
		int result = n1 + n2;
		System.out.printf("%d + %d = %d\n", n1, n2, result);
	}
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in); //���� �Է� ��ĳ��
		Scanner s2 = new Scanner(System.in); //���ڿ� �Է� ��ĳ��(yes/no)
		System.out.println("================= �� �� ���ϱ� =================");
		while(true)
		{
			System.out.print("* ���� 1 �Է�:");
			int n1 = s1.nextInt();
			
			System.out.print("* ���� 2 �Է�:");
			int n2 = s1.nextInt();
			
			add(n1, n2);
			
			System.out.print("* ����Ͻðڽ��ϱ�?(yes/no):");
			String conti = s2.next();
			if(conti.equals("no"))
					break;
		}
		s1.close();
		s2.close();

	}

}
