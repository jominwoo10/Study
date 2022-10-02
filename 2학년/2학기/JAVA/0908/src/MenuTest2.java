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
		setTitle("Menu ÀÌº¥Æ® ÇÁ·Î±×·¡¹Ö");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lbl = new JLabel("   ");
		lbl.setOpaque(true);
		lbl.setBackground(Color.WHITE);
		add(lbl, "South");
		
		// Menu ¸¸µé±â
		JMenuBar mBar = new JMenuBar();
		JMenu attack = new JMenu("°ø°İ");
		aGun = new JMenuItem("ÃÑ");
		aBomb = new JMenuItem("ÆøÅº");
		aLaser = new JMenuItem("·¹ÀÌÀú");
		attack.add(aGun);
		attack.add(aBomb);
		attack.add(aLaser);
		
		aGun.addActionListener(this);
		aBomb.addActionListener(this);
		aLaser.addActionListener(this);
		
		JMenu move = new JMenu("ÀÌµ¿"); 
		mForward = new JMenuItem("ÀüÁø");
		mBackward = new JMenuItem("ÈÄÅğ");
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
			s = "ÅÁÅÁÅÁ";
		}else if(eItem == aBomb) {
			s= "½´¿ì¿õ ~ Æã";
		}else if(eItem == aLaser) {
			s = "ÁãÀÌÀ×~";
		}else if(eItem == mForward) {
			s = "ÀüÁøÇÏ¶ó";
		}else if(eItem == mBackward) {
			s = "ÈÄÅğÇÏ¶ó";
		}
		
		lbl.setText(s);

	}

	public static void main(String[] args) {
		new MenuTest2();

	}

}
