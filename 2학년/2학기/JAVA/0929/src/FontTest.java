import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FontTest extends JFrame {
	
	public FontTest() {
		setTitle("Font ���� ����");
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
			g.drawString("1.��Ʈ ���� �� ����", 30, 80);
			Font f1 = new Font("���� ���",Font.BOLD+Font.ITALIC,20);
			g.setFont(f1);
			
			g.drawString("2.��Ʈ ���� �� ����", 30, 160);
			Font f2 = new Font("�ü�ü",Font.ITALIC,30);
			g.setFont(f2);
			g.drawString("3.��Ʈ ���� �� ����", 30, 240);
		}
	}

	public static void main(String[] args) {
		 new FontTest();
	}

}
