package test.Priority;

public class PriorityTest {

	public static void main(String[] args) {
		PriorityThread t1 = new PriorityThread("�켱���� ���� ������");
		t1.setPriority(Thread.MAX_PRIORITY);
		
		PriorityThread t2 = new PriorityThread("�켱���� ���� ������");
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
	}

}
