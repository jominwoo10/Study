package test.movingtext;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MovingText extends JLabel implements Runnable {
	String msg;
	int count = 1;
	
	public MovingText(String msg) {
		this.msg = msg;
		Thread t = new Thread(this);
		t.start();
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		setForeground(Color.BLUE);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			String s = msg.substring(0, count);
			setText(s);
			count %= msg.length();
			count++;
		}

	}

}
