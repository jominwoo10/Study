package test.movingtext;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MovingTextTest extends JFrame {

	public MovingTextTest() {
		super("�����̴� ���ڿ�");
		setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		MovingText lb1 = new MovingText("������ �ູ�� �������Դϴ�.");
		add(lb1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 150, 500, 150);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MovingTextTest();

	}

}
