package tset.anim;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnimationTest extends JFrame implements Runnable {
	JLabel lbl1;
	int x = 0;
	
	public AnimationTest() {
		getContentPane().setBackground(new Color(255,228,146));
		setLayout(null);
		ImageIcon icon = new ImageIcon("woman_right.gif");
		lbl1 = new JLabel(icon);
		lbl1.setBounds(x,250,150,150);
		add(lbl1);
		setTitle("°È´Â ¿©ÀÚ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setVisible(true);
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(300);
				lbl1.setLocation(x+=20, 250);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new AnimationTest();
	}

}
