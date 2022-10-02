import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JComboTest extends JFrame {
	
	public JComboTest() {
		setLayout(new FlowLayout());
		JLabel lblMeal = new JLabel("식사: ");
		JLabel lblDrink = new JLabel("음료: ");
		String[] mealTexts = {"돈까스","냉면","갈비탕","비빔밥","파스타"};
		String[] drinkTexts = {"콜라","사이다","환타","웰치스","맥주","와인"};
		JComboBox<String> comboMeal = new JComboBox<String>(mealTexts);
		JComboBox<String> combodrink = new JComboBox<String>(drinkTexts);
		
		add(lblMeal); add(comboMeal); add(lblDrink); add(combodrink); 
		
		setTitle("JComboBox 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 700, 500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		

		new JComboTest();
	}

}
