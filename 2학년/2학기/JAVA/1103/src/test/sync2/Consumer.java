package test.sync2;

import java.util.Random;

public class Consumer extends Thread {
	Buffer buf;
	
	public Consumer(Buffer buf) {
		this.buf = buf;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			int num = buf.get();
			try {
				sleep(Math.abs(r.nextInt()%100)+1);
			} catch (InterruptedException e) {
			}
		}
	}
}

