import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawStringTest extends JFrame {

	public DrawStringTest() {
		setTitle("drawSting() ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Mycanvas canvas = new Mycanvas();
		add(canvas,"Center");
		setBounds(1000, 200, 500, 300);
		setVisible(true);
		
	}
	
	class Mycanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawString("drawString()�� �������Դϴ�.", 100, 120);
		}
	}
	
	public static void main(String[] args) {
		new DrawStringTest();

	}

}
