
public class Circle {
	int r;
	double circum, area;
	
	public Circle(int r) {
		this.r = r;
	}
	
	public void calcCircum() {
		circum = 2 * Math.PI * r;
	}
	
	public void calcArea() {
		area = Math.PI * Math.pow(r, 2);
	}
	
	public void calcAndPrint() {
		ShowCircle.showResult(this);
	}
}
