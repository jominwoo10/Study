
public class ThisTest3 {
	int n;
	
	public ThisTest3() {
		System.out.println("ThisTest3() 생성자 호출됨");
		
	}
	
	public ThisTest3(int n) {
		this.n = n;
		System.out.println("ThisTest3(itn n) 생성자 호출됨: "+ this.n);
	}

	public static void main(String[] args) {
		new ThisTest3();

	}

}
