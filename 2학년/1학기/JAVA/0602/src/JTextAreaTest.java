import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaTest extends JFrame {
// 여러줄 입력 가능한 컴포넌트 : JTextArea
	public JTextAreaTest() {
		String[] lblTexts = {"작성자","글제목: ","글내용: "};
		JLabel[] lbls = new JLabel[lblTexts.length];
		String[] constraints = {"North","Center","South"};
		JPanel[] pans = new JPanel[constraints.length];
		for (int i = 0; i < pans.length; i++) {
			lbls[i] = new JLabel(lblTexts[i]);
			pans[i] = new JPanel();
			add(pans[i],constraints[i]);
		}
		
		JTextField tfWriter = new JTextField(15);
		JTextField tfTitle = new JTextField(20);
		JTextArea ta = new JTextArea(7,30);
		
		pans[0].add(lbls[0]); pans[0].add(tfWriter);
		pans[1].add(lbls[1]); pans[1].add(tfTitle);
		pans[2].add(lbls[2]); pans[2].add(ta);
		
		setTitle("JTextArea 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 500, 500, 250);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		
		new JTextAreaTest();
	}

}
