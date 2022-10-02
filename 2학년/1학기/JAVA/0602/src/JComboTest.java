import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JComboTest extends JFrame {
	
	public JComboTest() {
		setLayout(new FlowLayout());
		JLabel lblMeal = new JLabel("�Ļ�: ");
		JLabel lblDrink = new JLabel("����: ");
		String[] mealTexts = {"���","�ø�","������","�����","�Ľ�Ÿ"};
		String[] drinkTexts = {"�ݶ�","���̴�","ȯŸ","��ġ��","����","����"};
		JComboBox<String> comboMeal = new JComboBox<String>(mealTexts);
		JComboBox<String> combodrink = new JComboBox<String>(drinkTexts);
		
		add(lblMeal); add(comboMeal); add(lblDrink); add(combodrink); 
		
		setTitle("JComboBox ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 700, 500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		

		new JComboTest();
	}

}
