import java.awt.Color;

public class UserThread2 extends Thread {
	ThreadTest2 f;
	
	public UserThread2(ThreadTest2 f) {
		this.f = f;
	}
	
	@Override
	public void run() {
		f.setTitle("ȭ�� ���� ����");
		f.getContentPane().setBackground(Color.GREEN);
		
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.setTitle("��� ���");
		f.getContentPane().setBackground(Color.YELLOW);
		
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.setTitle("���� ���");
		f.getContentPane().setBackground(Color.RED);
		
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.setTitle("���� ���� ����");
		f.getContentPane().setBackground(Color.BLUE);
	}
}
