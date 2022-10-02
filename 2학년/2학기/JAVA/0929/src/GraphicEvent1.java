import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicEvent1 extends JFrame implements ActionListener{
	JButton btn1 = new JButton("�簢��");
	JButton btn2 = new JButton("��(Ÿ��)");
	
	public GraphicEvent1() {
		setTitle("�׷��� �̺�Ʈ ó�� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pan1 = new JPanel();
		pan1.add(btn1);
		pan1.add(btn2);
		add(pan1, "North");
		MyCanvas canvas = new MyCanvas();
		add(canvas);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		setBounds(1000, 200, 500, 400);
		setVisible(true);
	}
	
	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			switch (poly) {
			case 0: 
				g.drawRect(100, 50, 300, 250);
				break;
			case 1:
				g.drawOval(100, 50, 300, 250);
				break;
			}
		}
	}
	int poly = -1; //0�̸� �簢��, 1�̸� ��
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			poly = 0;
		}else {
			poly = 1;
		}
		repaint();
	}
	
	public static void main(String[] args) {
		new GraphicEvent1();

	}

}
