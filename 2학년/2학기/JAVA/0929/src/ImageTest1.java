import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTest1 extends JFrame {
	
	public ImageTest1() {
		setTitle("이미지 그리기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyCanvas canvas = new MyCanvas();
		add(canvas);
		
		setBounds(1000, 200, 600, 600);
		setVisible(true);
		
	}

	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			Toolkit t = Toolkit.getDefaultToolkit();
			Image img = t.getImage("imgs/fall1.jpg");
//			g.drawImage(img, 100, 100, this);
			g.drawImage(img, 0, 0, 275, 183, 275, 0, 0, 183, this);
		}
	}
	
	public static void main(String[] args) {
		new ImageTest1();
	}

}
