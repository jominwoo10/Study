
public class RunnableTest1 {

	public static void main(String[] args) {
		UserRunnable1 r1 = new UserRunnable1();
		r1.setName("First Thread");
		Thread t1 = new Thread(r1);
		t1.start();
		
		UserRunnable1 r2 = new UserRunnable1();
		r2.setName("Second Thread");
		Thread t2 = new Thread(r2);
		t2.start();
	}

}
