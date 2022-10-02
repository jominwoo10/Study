import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class JListTest extends JFrame {
	
	public JListTest() {
		setLayout(new FlowLayout());
		JLabel lbl = new JLabel("좋아하는 과일: ");
		String[] listItems = {"포도","사과","딸기","오렌지","참외"};
		JList<String> list = new JList<String>(listItems);
		add(lbl);
		add(list);
		
		setTitle("JList 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(700, 500);
		setSize(500, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new JListTest();

	}

}
