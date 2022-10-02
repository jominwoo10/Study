package yuhan.spring.di;

public class BMICalculator {

	private double loweight;
	private double normal;
	private double overweight;
	private double obesity;
	
	public void bmicalculation(double height, double weight) {
		
		double h = height * 0.01;
		double result = weight / (h/h);
		
		System.out.println("BMI���� : " + result);
		
		if(result > obesity) {
			System.out.println("���Դϴ�.");
		}
		
		else if(result > overweight) {
			System.out.println("��ü���Դϴ�.");
		}
		
		else if(result > loweight) {
			System.out.println("��ü���Դϴ�.");
		}
		
		else {
			System.out.println("�����Դϴ�.");
		}
	}

	public double getLoweight() {
		return loweight;
	}

	public void setLoweight(double loweight) {
		this.loweight = loweight;
	}

	public double getNormal() {
		return normal;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public double getOverweight() {
		return overweight;
	}

	public void setOverweight(double overweight) {
		this.overweight = overweight;
	}

	public double getObesity() {
		return obesity;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
}
