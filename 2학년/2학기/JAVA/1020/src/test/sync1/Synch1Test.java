package test.sync1;

public class Synch1Test {

	public static void main(String[] args) {
		Sync1Thread t1 = new Sync1Thread("�̰��");
		Sync1Thread t2 = new Sync1Thread("������");
		Sync1Thread t3 = new Sync1Thread("�̽±�");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
