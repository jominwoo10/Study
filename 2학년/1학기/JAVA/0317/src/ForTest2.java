
public class ForTest2 {

	public static void main(String[] args) {
		System.out.println("������ 2~9���� ����մϴ�.");
		
		for(int i = 2; i < 10; i++)
		{
			for(int j = 1; j <10; j++)
			{
				System.out.printf("%d*%d=%d\t",i,j,i*j);
			}
			System.out.println();
		}
	}

}
