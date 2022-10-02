package test.sync1;

public class Synch1Test {

	public static void main(String[] args) {
		Sync1Thread t1 = new Sync1Thread("이경규");
		Sync1Thread t2 = new Sync1Thread("유현주");
		Sync1Thread t3 = new Sync1Thread("이승기");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
