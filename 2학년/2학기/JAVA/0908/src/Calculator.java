import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener {
	
	JLabel lbl;
	String[] strs = {"0", ".", "C", "+", "-", "°ø", "°¿"};
	JButton[] btns = new JButton[16];
	JButton btnEq;
	
	public Calculator() {
		setTitle("∞ËªÍ±‚");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lbl = new JLabel("0",JLabel.RIGHT);
		Font font = new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30);
		lbl.setFont(font);
		
		JPanel p = new JPanel(new GridLayout(4,4));
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(i+1+"");
			if(i>=9) {
				btns[i] = new JButton(strs[i-9]);
			}
			btns[i].setFont(font);
			btns[i].addActionListener(this);
			p.add(btns[i]);
		}
		
		btnEq = new JButton("=");
		btnEq.addActionListener(this);
		btnEq.setFont(font);
		
		add(lbl, "North");
		add(p, "Center");
		add(btnEq, "South");
		
		setBounds(1000, 200, 300, 400);
		setVisible(true);
		
		
	}
	
	int init = 1; //∞ËªÍ±‚ Ω««‡ √ ±‚ªÛ≈¬∏È1, æ∆¥œ∏È 0
	double d1, d2, d3;
	int op = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton eBtn = (JButton) e.getSource();
		String s = lbl.getText();
		
		if(eBtn == btns[9]) {
			if(init == 1) {
				init = 1;
				lbl.setText("0");
			}else {
				s += "0";
				lbl.setText(s);
			}
		}
		
		// 1~9
		for (int i = 0; i < 9; i++) {
			if(eBtn == btns[i]) {
				if(init == 1) {
					init = 0;
					lbl.setText((i+1) + "");
				}else {
					s += i+1;
					lbl.setText(s);
				}
			}
		}
		
		// .≈∞
		if(eBtn == btns[10]) {
			if(init == 1) {
				init = 0;
				s += ".";
				lbl.setText(s);
			}else {
				s += ".";
				lbl.setText(s);
			}
		}
		
		// C≈∞ (Clear)
		if(eBtn == btns[11]) {
			lbl.setText("0");
			init = 1;
		}
		
		// +≈∞
		if(eBtn == btns[12]) {
			init = 1;
			op = 1; //µ°º¿¿∫ ø¨ªÍ¿⁄ 1
			d1 = Double.parseDouble(lbl.getText());
		}
		
		// -≈∞
		if(eBtn == btns[13]) {
			init = 1;
			op = 2; //ª¨º¿¿∫ ø¨ªÍ¿⁄ 2
			d1 = Double.parseDouble(lbl.getText());
		}
		
		// *≈∞
		if(eBtn == btns[14]) {
			init = 1;
			op = 3; //∞ˆº¿¿∫ ø¨ªÍ¿⁄ 3
			d1 = Double.parseDouble(lbl.getText());
		}
		
		// /≈∞
		if(eBtn == btns[15]) {
			init = 1;
			op = 4; //≥™¥∞º¿¿∫ ø¨ªÍ¿⁄ 4
			d1 = Double.parseDouble(lbl.getText());
		}
		
		// =≈∞
		if(eBtn == btnEq) {
			init = 1;
			
			d2 = Double.parseDouble(lbl.getText());
			
			switch(op) {
			case 1: //+
				d3 = d1 + d2;
				break;
			case 2: // -
				d3 = d1 - d2;
				break;
			case 3: // *
				d3 = d1 * d2;
				break;
			case 4: // /
				d3 = d1 / d2;
				break;
			}
			lbl.setText(d3 + "");
		}
				
	}

	public static void main(String[] args) {
		new Calculator();

	}

}
