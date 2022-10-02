package test.Priority;

public class PriorityThread extends Thread {

	public PriorityThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			System.out.println(getName() + ": " + (i+1));
		}
		System.out.println(getName() + " 실행종료");
	}
}
