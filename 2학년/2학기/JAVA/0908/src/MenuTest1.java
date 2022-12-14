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
		setTitle("메뉴 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mBar = new JMenuBar();
		mFile = new JMenu("파일");
		fOpen = new JMenuItem("열기");
		fSave = new JMenuItem("저장하기");
		fClose = new JMenuItem("닫기");
		fExit = new JMenu("종료하기");
		mFile.add(fOpen);
		mFile.add(fSave);
		mFile.add(fClose);
		mFile.add(fExit);
		
		xSave = new JMenuItem("저장하고 종료");
		xNoneSave = new JMenuItem("저장 안하고 종료");
		fExit.add(xSave);
		fExit.add(xNoneSave);
		
		mEdit = new JMenu("편집");
		eCopy = new JMenuItem("복사하기");
		ePaste = new JMenuItem("붙여넣기");
		mEdit.add(eCopy);
		mEdit.add(ePaste);
		
		mHelp = new JMenu("도움말");
		hShow = new JMenuItem("도움말 보기");
		mHelp.add(hShow);
		
		mBar.add(mFile);
		mBar.add(mEdit);
		mBar.add(mHelp);
		
		setJMenuBar(mBar); // 중요
		setBounds(1000, 200, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuTest1();

	}

}
