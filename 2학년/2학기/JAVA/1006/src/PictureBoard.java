import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PictureBoard extends JFrame implements ActionListener{
	public static final int RECT = 0;
	public static final int OVAL = 1;
	public static final int LINE = 2;
	public static final int FILL_LINE = 3;
	public static final int FILL_FILL = 4;

	/*
	String[] strItems = {"빨강","파랑","노랑","초록","검정","직사각형","타원","직선","채우기","선그리기"};
	JMenuItem[] mItems = new JMenuItem[strItems.length];
	*/
	
	JMenuBar cBar;
	JMenu cColor, cShpae,cFill,cMountin;
	JMenuItem cRed,cBlue,cYellow,cGreen,cBlack;
	JMenuItem cRectangle,cCircle,cLine;
	JMenuItem cLinedraw,cFi;
	JMenuItem cHanla,cSalak,cBackdu;
	
	// 상태(색상,모양,채우기) 필드 선언
	Color color = Color.RED;
	int shape = RECT;
	int fill = -1;
	String imgStr = "imgs/img01.jpg";
	
	public PictureBoard() {
		
		cBar = new JMenuBar();
		
		cColor = new JMenu("색상");
		cRed = new JMenuItem("빨강");
		cBlue = new JMenuItem("파랑");
		cYellow = new JMenuItem("노랑");
		cGreen = new JMenuItem("초록");
		cBlack = new JMenuItem("검정");
		cColor.add(cRed);
		cColor.add(cBlue);
		cColor.add(cYellow);
		cColor.add(cGreen);
		cColor.add(cBlack);
		
		cShpae = new JMenu("도형모양");
		cRectangle = new JMenuItem("직사각형");
		cCircle = new JMenuItem("원");
		cLine = new JMenuItem("직선");
		cShpae.add(cRectangle);
		cShpae.add(cCircle);
		cShpae.add(cLine);
		
		cFill = new JMenu("채우기");
		cLinedraw = new JMenuItem("선 그리기");
		cFi = new JMenuItem("채우기");
		cFill.add(cLinedraw);
		cFill.add(cFi);
		
		cMountin = new JMenu("산 이미지");
		cHanla = new JMenuItem("한라산");
		cSalak = new JMenuItem("설악산");
		cBackdu = new JMenuItem("백두산");
		cMountin.add(cHanla);
		cMountin.add(cSalak);
		cMountin.add(cBackdu);
		
		cBar.add(cColor);
		cBar.add(cShpae);
		cBar.add(cFill);
		cBar.add(cMountin);
		
		cRed.addActionListener(this);
		cBlue.addActionListener(this);
		cYellow.addActionListener(this);
		cGreen.addActionListener(this);
		cBlack.addActionListener(this);
		cRectangle.addActionListener(this);
		cCircle.addActionListener(this);
		cLine.addActionListener(this);
		cLinedraw.addActionListener(this);
		cFi.addActionListener(this);
		cHanla.addActionListener(this);
		cSalak.addActionListener(this);
		cBackdu.addActionListener(this);
		
		setJMenuBar(cBar); // 중요
		
		MyCanvas canvas = new MyCanvas();
		add(canvas);
		
		setTitle("간단한 그림판");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 600, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PictureBoard();
	}

	public class MyCanvas extends JPanel{
		public MyCanvas() {
			setBackground(color.WHITE);
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(color);
			int width = 400;
			int height = 300;
			switch(fill) {
			case FILL_LINE:
				switch(shape) {
				case RECT:
					g.drawRect(50, 50, width, height);
					break;
				case OVAL:
					g.drawOval(50, 50, width, height);
					break;
				case LINE:
					g.drawLine(50, 50, width, height);
					break;
				}
				break;
			case FILL_FILL:
				switch(shape) {
				case RECT:
					g.fillRect(50, 50, width, height);
					break;
				case OVAL:
					g.fillOval(50, 50, width, height);
					break;
				case LINE:
					g.drawLine(50, 50, width, height);
					break;
				}
				break;
				
				default:
					Toolkit tk = Toolkit.getDefaultToolkit();
					Image img = tk.getImage(imgStr);
					g.drawImage(img,50,50,this);
					fill = FILL_LINE;
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cRed)
		{
			color = Color.RED;
		}
		else if(e.getSource() == cBlue)
		{
			color = Color.BLUE;
		}
		else if(e.getSource() == cYellow)
		{
			color = Color.YELLOW;
		}
		else if(e.getSource() == cGreen)
		{
			color = Color.GREEN;
		}
		else if(e.getSource() == cBlack)
		{
			color = Color.BLACK;
		}
		else if(e.getSource() == cRectangle)
		{
			shape = RECT;
		}
		else if(e.getSource() == cCircle)
		{
			shape = OVAL;
		}
		else if(e.getSource() == cLine)
		{
			shape = LINE;
		}
		else if(e.getSource() == cLinedraw)
		{
			fill = FILL_LINE;
		}
		else if(e.getSource() == cFi)
		{
			fill = FILL_FILL;
		}
		else if(e.getSource() == cHanla)
		{
			imgStr = "imgs/img01.jpg";
			fill = -1;
		}
		else if(e.getSource() == cSalak)
		{
			imgStr = "imgs/img02.jpg";
			fill = -1;
		}
		else if(e.getSource() == cBackdu)
		{
			imgStr = "imgs/img03.jpg";
			fill = -1;
		}
		repaint();
	}

}