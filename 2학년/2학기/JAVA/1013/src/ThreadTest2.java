import javax.swing.JFrame;

public class ThreadTest2 extends JFrame {

	public ThreadTest2() {
		setTitle("배경색상변경예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300,150,500,400);
		setVisible(true);
		UserThread2 t = new UserThread2(this);
		t.start();
	}
	public static void main(String[] args) {
		new ThreadTest2();

	}

}
