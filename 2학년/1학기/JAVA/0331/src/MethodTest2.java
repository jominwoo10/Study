import java.util.Scanner;

public class MethodTest2 {
	
	public static void hol(int num)
	{
		String result =""; //����ִ� ���ڿ�(Empty String)
		if(num % 2 == 0)
			result = "¦��";
		else
			result = "Ȧ��";
		
		System.out.printf("%d��(��) %s�Դϴ�.\n",num,result);
	}

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in); //���� �Է� ��ĳ��
		Scanner s2 = new Scanner(System.in); //���ڿ� �Է� ��ĳ��(yes/no)
		System.out.println("================= Ȧ ¦ �˾ƺ��� =================");
		while(true)
		{
			System.out.print("* ���� �Է�:");
			
			int num = s1.nextInt();
			hol(num);
			
			System.out.print("* ����Ͻðڽ��ϱ�?(yes/no):");
			String conti = s2.next();
			if(conti.equals("no"))
					break;
		}
		
		s1.close();
		s2.close();
	}
	
}
