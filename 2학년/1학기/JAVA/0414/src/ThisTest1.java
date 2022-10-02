
public class ThisTest1 {
	double n;
	
	void power(double n) {
		this.n = Math.pow(n, 2);
		System.out.printf("%.1f * %.1f = %.1f", n, n, this.n);
	}

	public static void main(String[] args) {
		ThisTest1 t = new ThisTest1();
		t.power(5.0);

	}

}
