package test.url;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLTest extends JFrame {
	JTextField tf;
	JTextArea area;
	
	public URLTest() {
		JLabel lbl1 = new JLabel("ȣ��Ʈ�̸�");
		tf = new JTextField(20);
		JButton btnCheck = new JButton("�о����");
		area = new JTextArea();
		area.setEditable(false);
		JLabel lbl2 = new JLabel("�о�� ȣ��Ʈ�� �̸��� �Է��ϼ���.");
		JPanel pan = new JPanel();
		pan.add(lbl1);
		pan.add(tf);
		pan.add(btnCheck);
		
		JScrollPane sp = new JScrollPane(area);
		
		add(pan,"North");
		add(sp,"Center");
		add(lbl2,"South");
		
		btnCheck.addActionListener(btnListener);
		
		setTitle("URL Ŭ���� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50, 100, 600, 500);
		setVisible(true);
	}
	
	ActionListener btnListener = new ActionListener() {
		
		@Override	
		public void actionPerformed(ActionEvent e) {
			area.setText("");
			try {
				URL url = new URL("https://" + tf.getText());
				InputStream in =url.openStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
				String line="";
				while((line = br.readLine())!= null) {
					area.append(line + "\n");
				}
				in.close();
				br.close();
			} catch (MalformedURLException e1) {
				System.out.println("���Ŀ� ���� �ʴ� url �Դϴ�.");
			} catch (IOException e1) {
				System.out.println("�Է½�Ʈ���� ������ �߻��߽��ϴ�.");
			}
		}
	};
	
	public static void main(String[] args) {
		new URLTest();
	}

}
