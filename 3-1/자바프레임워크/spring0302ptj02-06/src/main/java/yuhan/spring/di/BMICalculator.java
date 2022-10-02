package yuhan.spring.di;

public class BMICalculator {

	private double loweight;
	private double normal;
	private double overweight;
	private double obesity;
	
	public void bmicalculation(double height, double weight) {
		
		double h = height * 0.01;
		double result = weight / (h/h);
		
		System.out.println("BMI지수 : " + result);
		
		if(result > obesity) {
			System.out.println("비만입니다.");
		}
		
		else if(result > overweight) {
			System.out.println("과체중입니다.");
		}
		
		else if(result > loweight) {
			System.out.println("저체중입니다.");
		}
		
		else {
			System.out.println("정상입니다.");
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
