package test.sync2;

public class Buffer {
	int data;
	boolean available;
	
	public synchronized void put(int num) {
		while(available == true){ //쌀통이 채워져 있을 동안
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		data = num;
		System.out.println("생산자: " + num);
		available = true;
		notifyAll();
	}
		
	public synchronized int get() {//Consumer(소비자)
		
		while(available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("소비자: "+data);
		available = false;
		notifyAll();
		return data;
	}
}
