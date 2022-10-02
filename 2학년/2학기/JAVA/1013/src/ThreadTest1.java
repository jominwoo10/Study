
public class ThreadTest1 {
	public static void main(String[] args) {
		UserThread1 t1 = new UserThread1("First Thread");
		UserThread1 t2 = new UserThread1("Second Thread");
		
		t1.start();
		t2.start();
	}
}
