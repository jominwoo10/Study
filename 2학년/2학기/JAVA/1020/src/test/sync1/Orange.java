package test.sync1;

public class Orange {
	static int orange_count = 50;
	
	public static synchronized void takeOut(String name, int num) {
		if(orange_count >= num) {
			orange_count -= num;
			System.out.println(name + "��(��) �������� " + num + "�� ������.");
		}else {
			System.out.println(name + "�� ������ ������ �����մϴ�.");
			
		}
		System.out.println("** ���� �������� ������ " + orange_count + "���Դϴ�.");
	}
}
