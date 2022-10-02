package test.clock;

import java.util.Calendar;

import javax.swing.JLabel;

public class ClockThread implements Runnable {
	JLabel lb1, lb2;
	
	public ClockThread(JLabel lb1, JLabel lb2) {
		this.lb1 = lb1;
		this.lb2 = lb2;
	}
	
	@Override
	public void run() {
		Calendar c;
		String s1, s2;
		int year, month, date, hour, min, sec;
		while(true) {
			c = Calendar.getInstance();
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH)+1;
			date = c.get(Calendar.DATE);
			hour = c.get(Calendar.HOUR);
			min = c.get(Calendar.MINUTE);
			sec = c.get(Calendar.SECOND);
			s1 = year + "년 " + month + "월 " + date + "일";
			s2 = hour + "시 " + min + "분 " + sec + "초";
			lb1.setText(s1);
			lb2.setText(s2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			
		}

	}

}
