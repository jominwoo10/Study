
public class UserThread1 extends Thread {
	int count;
	
	public UserThread1(String name) {
		//setName(name);
		super(name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(getName() + "=>" + ++count);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
