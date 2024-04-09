package calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
	InputSpace inputSpace = new InputSpace();
	Keyboard keyboard = new Keyboard();
	ChangePanel changePanel = new ChangePanel();
	
	
	
	
	public Calculator() {
		
		setTitle("계산기");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		//Frame에 패널추가
		c.add(inputSpace,BorderLayout.NORTH);
		c.add(keyboard,BorderLayout.CENTER);
		c.add(changePanel,BorderLayout.SOUTH);
		setSize(400,700);
		setVisible(true);
		
	}
	
	//main 메소드
	public static void main(String[] args) {
		new Calculator();
	}
	
	//상단창 클래스
	class InputSpace extends JPanel{
		
	
		
		
		
		public InputSpace() {
			 JLabel label;
			 JLabel info;
			setLayout(new GridLayout(3, 1));
			setBackground(Color.LIGHT_GRAY);
			info = new JLabel("");
			label = new JLabel("0");
			
			info.setFont(new Font("", 0, 40));
			info.setForeground(Color.BLACK);
			info.setHorizontalAlignment(SwingConstants.RIGHT);

			
			label.setFont(new Font("",Font.BOLD , 55));
			label.setForeground(Color.BLACK);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			
			add(info);
			add(label);
		}
	}
	

	//센터 창 클래스
	class Keyboard extends JPanel {
		

		public Keyboard() {
			
			
			JButton[] button = new JButton[20];
			this.setLayout(new GridLayout(5,4));
			setSize(400,600);
			this.setBackground(Color.DARK_GRAY);
			
			String arr[]= {"×","÷","AC","C",
						   "7","8","9","√",
						   "4","5","6","-",
						   "1","2","3","+",
						   "＾2","0",".","="};
			
			
			for(int i= 0 ; i<20;i++) {
				button[i] = new JButton(arr[i]);
				add(button[i]);
				setSize(120,100);
			}
			
			
			
			}
		
		}

	class Keyboard2 extends JPanel {
		
		
		
		
		public Keyboard2() {
			
		}
	}
	
	class ChangePanel extends JButton{
		public ChangePanel() {
			JButton change = new JButton();
			change.setText(">>>");
			
			add(change);
			
			
		}
	
	        }
	     
	}






	
	
	
	



