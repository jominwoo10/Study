
public class ShowCircle {

	public static void showResult(Circle c) {
		c.calcCircum();
		c.calcArea();
		System.out.printf("* 반지름 %d㎝인 원의 둘레: %.1f㎝\n", c.r,c.circum);
		System.out.printf("* 반지름 %d㎝인 원의 면적: %.1f㎤\n", c.r,c.area);
	}
}
