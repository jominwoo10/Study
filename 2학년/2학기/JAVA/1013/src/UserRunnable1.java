
public class UserRunnable1 implements Runnable {
	String name;
	int count;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(getName() + "=>" + ++count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
