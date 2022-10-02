import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;



public class JCheckTest extends JFrame {
	public JCheckTest() {
		setLayout(new FlowLayout());
		String[] checkTexts = {"����","����","����","����","������"};
		boolean[] checkBools = {true,false,true,true,false};
		JCheckBox[] checks = new JCheckBox[checkTexts.length];
		for (int i = 0; i < checks.length; i++) {
			checks[i] = new JCheckBox(checkTexts[i], checkBools[i]);
			add(checks[i]);
		}
		//checks[3].setSelected(true);
		
		setTitle("JCheckBox ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 500, 500, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new JCheckTest();
	}

}
