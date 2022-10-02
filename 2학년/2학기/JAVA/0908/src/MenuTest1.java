import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuTest1 extends JFrame {
	
	JMenuBar mBar;
	JMenu mFile, mEdit, mHelp;
	JMenu fExit;
	JMenuItem fOpen, fSave, fClose;
	JMenuItem eCopy, ePaste;
	JMenuItem hShow;
	JMenuItem xSave, xNoneSave;

	public MenuTest1() {
		setTitle("�޴� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mBar = new JMenuBar();
		mFile = new JMenu("����");
		fOpen = new JMenuItem("����");
		fSave = new JMenuItem("�����ϱ�");
		fClose = new JMenuItem("�ݱ�");
		fExit = new JMenu("�����ϱ�");
		mFile.add(fOpen);
		mFile.add(fSave);
		mFile.add(fClose);
		mFile.add(fExit);
		
		xSave = new JMenuItem("�����ϰ� ����");
		xNoneSave = new JMenuItem("���� ���ϰ� ����");
		fExit.add(xSave);
		fExit.add(xNoneSave);
		
		mEdit = new JMenu("����");
		eCopy = new JMenuItem("�����ϱ�");
		ePaste = new JMenuItem("�ٿ��ֱ�");
		mEdit.add(eCopy);
		mEdit.add(ePaste);
		
		mHelp = new JMenu("����");
		hShow = new JMenuItem("���� ����");
		mHelp.add(hShow);
		
		mBar.add(mFile);
		mBar.add(mEdit);
		mBar.add(mHelp);
		
		setJMenuBar(mBar); // �߿�
		setBounds(1000, 200, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuTest1();

	}

}
