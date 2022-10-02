import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawArcTest extends JFrame {
	
	public DrawArcTest() {
		setTitle("drawRect() ¿¬½À");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyCanvas canvas = new MyCanvas();
		add(canvas,"Center");
		setBounds(1000, 200, 500, 500);
		setVisible(true);
	}
	
	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawArc(100, 70, 300, 300, 45, 180);
			g.drawArc(50,100,400,250,120,270);
		}
	}

	public static void main(String[] args) {
		new DrawArcTest();

	}

}
