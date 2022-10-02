import java.util.Scanner;

public class MethodTest2 {
	
	public static void hol(int num)
	{
		String result =""; //비어있는 문자열(Empty String)
		if(num % 2 == 0)
			result = "짝수";
		else
			result = "홀수";
		
		System.out.printf("%d는(은) %s입니다.\n",num,result);
	}

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in); //숫자 입력 스캐너
		Scanner s2 = new Scanner(System.in); //문자열 입력 스캐너(yes/no)
		System.out.println("================= 홀 짝 알아보기 =================");
		while(true)
		{
			System.out.print("* 정수 입력:");
			
			int num = s1.nextInt();
			hol(num);
			
			System.out.print("* 계속하시겠습니까?(yes/no):");
			String conti = s2.next();
			if(conti.equals("no"))
					break;
		}
		
		s1.close();
		s2.close();
	}
	
}
