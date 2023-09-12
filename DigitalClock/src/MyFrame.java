import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{

	Calendar calender;
	SimpleDateFormat timeformat;
	SimpleDateFormat  dayformat;
	SimpleDateFormat  dateformat;
	JLabel timelabel;
	JLabel daylabel;
	JLabel datelabel;
	String time;
	String day;
	String date;

	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Clock");
		this.setLayout(new FlowLayout());
		this.setSize(350, 230);
		this.setResizable(false);
		this.setVisible(true);
		
		timeformat = new SimpleDateFormat("hh:mm:ss a");
		timelabel = new JLabel();
		timelabel.setFont(new Font(Font.DIALOG,Font.PLAIN,50));
		time = timeformat.format(calender.getInstance().getTime());
		timelabel.setText(time);
		timelabel.setForeground(new Color(0xda5c95));
		timelabel.setBackground(Color.BLACK);
		timelabel.setOpaque(true);
		this.add(timelabel);
		
		dayformat = new SimpleDateFormat("EEEE");
		daylabel = new JLabel();
		daylabel.setFont(new Font("Ink free",Font.BOLD,40));
//		daylabel.setBackground(Color.BLACK);
//		daylabel.setOpaque(true);
		this.add(daylabel);
		
		dateformat = new SimpleDateFormat("MMMMM dd, yyyy");
		datelabel = new JLabel();
		datelabel.setFont(new Font("Ink free",Font.BOLD,30));
//		datelabel.setBackground(Color.BLACK);
//		datelabel.setOpaque(true);
		this.add(datelabel);
		setTime();

	}

	public void setTime() {

		while(true) {
			time = timeformat.format(calender.getInstance().getTime());
			timelabel.setText(time);

			day = dayformat.format(calender.getInstance().getTime());
			daylabel.setText(day);
			
			date = dateformat.format(calender.getInstance().getTime());
			datelabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
