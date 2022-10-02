import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FillRectOvalTest extends JFrame {
	
	public FillRectOvalTest() {
		setTitle("fil***() ¿¬½À");
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
			g.setColor(Color.ORANGE);
			g.fillRect(100, 50, 300, 200);
			g.setColor(new Color(255,0,255));
			g.fillOval(150, 100, 200, 100);
		}
	}
	public static void main(String[] args) {
		new FillRectOvalTest();

	}

}
