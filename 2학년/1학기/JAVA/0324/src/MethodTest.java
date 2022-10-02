
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
		print_head('♣',30);
		System.out.println("유한대학교");
		print_head('★',50);
		System.out.println("컴퓨터소프트웨어공학과");
		print_head('☆',40);
	}

}
