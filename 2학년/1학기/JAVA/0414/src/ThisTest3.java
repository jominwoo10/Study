
public class ThisTest3 {
	int n;
	
	public ThisTest3() {
		System.out.println("ThisTest3() ������ ȣ���");
		
	}
	
	public ThisTest3(int n) {
		this.n = n;
		System.out.println("ThisTest3(itn n) ������ ȣ���: "+ this.n);
	}

	public static void main(String[] args) {
		new ThisTest3();

	}

}
