
public class MethodTest {

	public static void print_head(char c, int count) 
	{
		for (int i = 0; i < count; i++) 
		{
			System.out.print(c);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		print_head('��',30);
		System.out.println("���Ѵ��б�");
		print_head('��',50);
		System.out.println("��ǻ�ͼ���Ʈ������а�");
		print_head('��',40);
	}

}
