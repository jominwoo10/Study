package test.clock;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunnableClockTest extends JFrame {

	public RunnableClockTest() {
		JLabel lb1 = new JLabel("��¥ ������ ��", JLabel.CENTER);
		JLabel lb2 = new JLabel("�ð� ������ ��", JLabel.CENTER);
		Font font = new Font("���� ���",Font.BOLD, 25);
		lb1.setFont(font);
		lb2.setFont(font);
		add(lb1, "North");
		add(lb2, "Center");
		setTitle("Runnable Thread Clock");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 150, 400, 150);
		setVisible(true);
		ClockThread ct = new ClockThread(lb1, lb2);
		Thread t = new Thread(ct);
		t.start();
	}
	public static void main(String[] args) {
		new RunnableClockTest();

	}

}
