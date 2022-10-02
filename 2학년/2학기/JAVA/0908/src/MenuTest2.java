import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuTest2 extends JFrame implements ActionListener {
	JLabel lbl;
	JMenuItem aGun, aBomb, aLaser;
	JMenuItem mForward, mBackward;
	public MenuTest2() {
		setTitle("Menu �̺�Ʈ ���α׷���");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lbl = new JLabel("   ");
		lbl.setOpaque(true);
		lbl.setBackground(Color.WHITE);
		add(lbl, "South");
		
		// Menu �����
		JMenuBar mBar = new JMenuBar();
		JMenu attack = new JMenu("����");
		aGun = new JMenuItem("��");
		aBomb = new JMenuItem("��ź");
		aLaser = new JMenuItem("������");
		attack.add(aGun);
		attack.add(aBomb);
		attack.add(aLaser);
		
		aGun.addActionListener(this);
		aBomb.addActionListener(this);
		aLaser.addActionListener(this);
		
		JMenu move = new JMenu("�̵�"); 
		mForward = new JMenuItem("����");
		mBackward = new JMenuItem("����");
		move.add(mForward);
		move.add(mBackward);
		
		mForward.addActionListener(this);
		mBackward.addActionListener(this);
		
		mBar.add(attack);
		mBar.add(move);
		setJMenuBar(mBar);
		setBounds(1000, 200, 400, 300);
		setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object eItem = e.getSource();
		String s = "";
		
		if(eItem == aGun) {
			s = "������";
		}else if(eItem == aBomb) {
			s= "����� ~ ��";
		}else if(eItem == aLaser) {
			s = "������~";
		}else if(eItem == mForward) {
			s = "�����϶�";
		}else if(eItem == mBackward) {
			s = "�����϶�";
		}
		
		lbl.setText(s);

	}

	public static void main(String[] args) {
		new MenuTest2();

	}

}
