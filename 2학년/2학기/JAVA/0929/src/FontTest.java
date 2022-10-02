import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FontTest extends JFrame {
	
	public FontTest() {
		setTitle("Font 설정 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyCanvas canvas = new MyCanvas();
		add(canvas, "Center");
		setBounds(1000, 200, 500, 400);
		setVisible(true);
		
	}
	
	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawString("1.폰트 설정 및 수정", 30, 80);
			Font f1 = new Font("맑은 고딕",Font.BOLD+Font.ITALIC,20);
			g.setFont(f1);
			
			g.drawString("2.폰트 설정 및 수정", 30, 160);
			Font f2 = new Font("궁서체",Font.ITALIC,30);
			g.setFont(f2);
			g.drawString("3.폰트 설정 및 수정", 30, 240);
		}
	}

	public static void main(String[] args) {
		 new FontTest();
	}

}
