import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("* ���� �Է�");
		int age = s.nextInt();
		
		String result = age > 20 ? "����" : "�̼���";
		
		System.out.println("����� " + result + "�Դϴ�");
	}

}
