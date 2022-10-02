package test.movingtext;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MovingTextTest extends JFrame {

	public MovingTextTest() {
		super("움직이는 문자열");
		setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		MovingText lb1 = new MovingText("오늘은 행복한 수요일입니다.");
		add(lb1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 150, 500, 150);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MovingTextTest();

	}

}
