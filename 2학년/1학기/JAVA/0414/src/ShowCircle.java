
public class ShowCircle {

	public static void showResult(Circle c) {
		c.calcCircum();
		c.calcArea();
		System.out.printf("* ������ %d���� ���� �ѷ�: %.1f��\n", c.r,c.circum);
		System.out.printf("* ������ %d���� ���� ����: %.1f��\n", c.r,c.area);
	}
}
