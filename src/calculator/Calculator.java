package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
	InputSpace inputSpace = new InputSpace();
	Keyboard keyboard = new Keyboard();
	ChangePanel changePanel = new ChangePanel();
	String expression;
	static JLabel label;
	static JLabel info;
	double num = 0;
	double result = 0;
	
	
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
			
			setLayout(new GridLayout(3, 1));
			setBackground(Color.LIGHT_GRAY);
			info = new JLabel(" ");
			label = new JLabel(" ");
			
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
			
			String arr[]= {"×","÷","AC","CE",
						   "7","8","9","√",
						   "4","5","6","-",
						   "1","2","3","+",
						   "＾2","0",".","="};
			
			
			for(int i= 0 ; i<20;i++) {
				button[i] = new JButton(arr[i]);
				add(button[i]);
				setSize(120,100);
				button[i].addActionListener(new BtnListener());
				
			}
			
			
			}
			//하단버튼
			
			
			
			
			}
	
	
	
		class Keyboard2 extends JPanel {
		
		private JPanel win;
		public Keyboard2() {
			
		}
		
		}
	
	class BtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String operation = e.getActionCommand();
			
			
			if(operation.equals("AC")) {
				label.setText(" ");
				info.setText(" ");
			}
			else if(operation.equals("CE")) {
				int n = label.getText().length();
				if(n>0) {
					setBackSpace(getBackSpace().substring(0, getBackSpace().length() - 1));
				}
				if(label.getText() == "") {
					label.setText("0");
				}
				
						
			}else if(operation.equals("=")){
					String value = String.valueOf(result); 
					String str= label.getText(); 
					info.setText(str);
					label.setText(value);
					result = 0;
					num = 0;
			}else
			{
				label.setText(label.getText()+ operation);
			}
			
		}
	}

	class ChangePanel extends JPanel{
		private JPanel win;
		
		public ChangePanel() {
			this.win = win;
			
			setLayout(new FlowLayout());
			JButton change = new JButton();
			change.setText(">>>");
			
			add(change);
			
			
			change.addActionListener(new MyActionListener());
			
		}
		
		class MyActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
	        @Override
	        public void actionPerformed(ActionEvent e) {
	          
	        }
	     }
	
	        }
	class Calculate implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private void setBackSpace(String bs) {
		label.setText(bs);
	}
	
	private String getBackSpace() {
		return label.getText();
	}
	
	
	
	}






	
	
	
	



