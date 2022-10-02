import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPolygonTest extends JFrame {
	
	public DrawPolygonTest() {
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
			int[] xPoints = {250,50,450};
			int[] yPoints = {50,400,400};
			
			g.drawPolygon(xPoints, yPoints, xPoints.length);
		}
	}

	public static void main(String[] args) {
		new DrawPolygonTest();

	}

}
