package test.inet;

import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class INetAddressTest extends JFrame {
	JTextField tf;
	JTextArea area;
	
	public INetAddressTest() {
		JLabel lbl1 = new JLabel("호스트이름");
		tf = new JTextField(20);
		JButton btnCheck = new JButton("검사실행");
		area = new JTextArea();
		area.setEditable(false);
		JLabel lbl2 = new JLabel("검사할 호스트의 이름을 입력하세요.");
		JPanel pan = new JPanel();
		pan.add(lbl1);
		pan.add(tf);
		pan.add(btnCheck);
		add(pan,"North");
		add(area,"Center");
		add(lbl2,"South");
		
		btnCheck.addActionListener(btnListener);
		
		setTitle("InetAddress 클래스 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50, 100, 600, 500);
		setVisible(true);
	}
	
	ActionListener btnListener = new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent e) {
			area.setText("");			
			String hostName = tf.getText();
			try {
				InetAddress ia = InetAddress.getByName(hostName);
				area.append("getHostName(): " + ia.getHostName() + "\n");
				area.append("getHostAddress(): " + ia.getHostAddress() + "\n");
				area.append("toString(): " + ia.toString() + "\n");
				byte[] ipAddr = ia.getAddress();
				area.append("getAddress() : "+Arrays.toString(ipAddr)+ "\n");
				String result = "";
				for (int i = 0; i < ipAddr.length; i++) {
					result += ipAddr[i] < 0 ? ipAddr[i]+256 : ipAddr[i];
					result += ".";
				}
				area.append("getAddress()+256 : " + result + "\n");
				
				area.append("\n************ Local Computer Information *************\n");
				
				ia = InetAddress.getLocalHost();
				area.append("getHostName(): " + ia.getHostName() + "\n");
				area.append("getHostAddress(): " + ia.getHostAddress() + "\n");
				
			} catch (UnknownHostException e1) {
				System.out.println("알수없는 호스트이름");
			}
		}
	};
	
	public static void main(String[] args) {
		new INetAddressTest();
	}

}
