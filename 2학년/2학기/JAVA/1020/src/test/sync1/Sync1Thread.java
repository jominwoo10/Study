package test.sync1;

import java.util.Random;

public class Sync1Thread extends Thread {
	
	public Sync1Thread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			if(Orange.orange_count ==0) {
				System.out.println("���� ��� �����Ǽ� ������ �� �����ϴ�.");
				return;
			}
			Orange.takeOut(getName(), Math.abs(r.nextInt(7)+1));
		}
	}
}
