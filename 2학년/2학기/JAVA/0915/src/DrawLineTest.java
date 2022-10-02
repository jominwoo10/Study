import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLineTest extends JFrame {

	public DrawLineTest() {
		setTitle("drawLine()¿¬½À");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyCanvas canvas = new MyCanvas();
		add(canvas,"Center");
		setBounds(1000, 200, 500, 400);
		setVisible(true);
	}
	
	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawLine(100, 70, 400, 300);
			g.drawLine(250,30,250,350);
		}
	}
	public static void main(String[] args) {
		new DrawLineTest();

	}

}
