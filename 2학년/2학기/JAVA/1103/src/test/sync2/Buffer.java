package test.sync2;

public class Buffer {
	int data;
	boolean available;
	
	public synchronized void put(int num) {
		while(available == true){ //������ ä���� ���� ����
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		data = num;
		System.out.println("������: " + num);
		available = true;
		notifyAll();
	}
		
	public synchronized int get() {//Consumer(�Һ���)
		
		while(available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("�Һ���: "+data);
		available = false;
		notifyAll();
		return data;
	}
}
