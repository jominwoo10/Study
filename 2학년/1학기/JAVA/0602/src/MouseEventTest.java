import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventTest extends JFrame implements MouseListener {
	JLabel lbl;
	public MouseEventTest() {
		lbl = new JLabel("JFrame에 MouseEvent를 발생시키세요~");
		add(lbl);
		addMouseListener(this);
		setTitle("MouseEvent 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 700, 500, 300);
		setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		lbl.setText("JFrame에 마우스가 클릭되었음");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		lbl.setText("JFrame에 마우스가 눌렀음");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		lbl.setText("JFrame에 마우스가 떼었음");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		lbl.setText("JFrame에 마우스가 들어옴");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		lbl.setText("JFrame에 마우스가 나감");

	}

	public static void main(String[] args) {
		new MouseEventTest();

	}

}
