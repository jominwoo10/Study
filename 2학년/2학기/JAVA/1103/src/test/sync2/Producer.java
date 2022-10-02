package test.sync2;

import java.util.Random;

public class Producer extends Thread {
	Buffer buf;
	
	public Producer(Buffer buf) {
		this.buf = buf;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			buf.put(i+1);
			try {
				sleep(Math.abs(r.nextInt()%100));
			} catch (InterruptedException e) {
			}
		}
	}
}
