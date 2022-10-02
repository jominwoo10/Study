import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunnableClockTest extends JFrame {

	public RunnableClockTest() {
		JLabel lb1 = new JLabel("날짜 나오는 라벨", JLabel.CENTER);
		JLabel lb2 = new JLabel("시각 나오는 라벨", JLabel.CENTER);
		Font font = new Font("맑은 고딕",Font.BOLD, 25);
		lb1.setFont(font);
		lb2.setFont(font);
		add(lb1, "North");
		add(lb2, "Center");
		setTitle("Runnable Thread Clock");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 150, 400, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new RunnableClockTest();

	}

}
