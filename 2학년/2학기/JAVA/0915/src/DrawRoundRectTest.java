import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawRoundRectTest extends JFrame {
	
	public DrawRoundRectTest() {
		setTitle("drawRect() ¿¬½À");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyCanvas canvas = new MyCanvas();
		add(canvas, "Center");
		setBounds(1000, 200, 500, 500);
		setVisible(true);
	}

	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRoundRect(50, 150, 400, 250, 30, 30);
			g.drawRoundRect(150,70,250,350,70,70);
		}
	}
	public static void main(String[] args) {
		new DrawRoundRectTest();

	}

}
