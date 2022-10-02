import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventTest extends JFrame implements MouseListener {
	JLabel lbl;
	public MouseEventTest() {
		lbl = new JLabel("JFrame�� MouseEvent�� �߻���Ű����~");
		add(lbl);
		addMouseListener(this);
		setTitle("MouseEvent ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 700, 500, 300);
		setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		lbl.setText("JFrame�� ���콺�� Ŭ���Ǿ���");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		lbl.setText("JFrame�� ���콺�� ������");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		lbl.setText("JFrame�� ���콺�� ������");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		lbl.setText("JFrame�� ���콺�� ����");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		lbl.setText("JFrame�� ���콺�� ����");

	}

	public static void main(String[] args) {
		new MouseEventTest();

	}

}
