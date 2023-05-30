import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Calculator extends JFrame implements ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Ink free",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
			
	
	Calculator(){
		
		frame = new JFrame("Calculator");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(420, 550);
	    frame.setLayout(null);
	    frame.addKeyListener(this);
	    frame.setFocusable(true);

	    ImageIcon icon = new ImageIcon("resources/475497.png");
	    frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(Color.black);
			
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setForeground(Color.white);
		textfield.setEditable(false);
		textfield.setBackground(Color.black);
		textfield.addKeyListener(this);
		
		
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("AC");
		negButton = new JButton("+/-");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for (int i = 0; i < 10; i++) {
		    numberButtons[i] = new JButton(String.valueOf(i));
		    numberButtons[i].addActionListener(this);
		    numberButtons[i].setFont(myFont);
		    numberButtons[i].setFocusable(false);
		    numberButtons[i].setBackground(Color.GRAY);
		    numberButtons[i].setForeground(Color.BLACK);
			}
		
		negButton.setBounds(50,430,90,50);
		delButton.setBounds(150,430,90,50);
		clrButton.setBounds(250,430,90,50);
		negButton.setBackground(Color.LIGHT_GRAY);
		delButton.setBackground(Color.LIGHT_GRAY);
		clrButton.setBackground(Color.LIGHT_GRAY);
		addButton.setBackground(Color.orange);
		subButton.setBackground(Color.orange);
		mulButton.setBackground(Color.orange);
		divButton.setBackground(Color.orange);
		decButton.setBackground(Color.orange);
		equButton.setBackground(Color.orange);
		
		
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.black);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
		
		for (int i = 0; i < 10; i++) {
		    numberButtons[i].addKeyListener(this);
		}
		addButton.addKeyListener(this);
		subButton.addKeyListener(this);
		mulButton.addKeyListener(this);
		divButton.addKeyListener(this);
		decButton.addKeyListener(this);
		equButton.addKeyListener(this);
		delButton.addKeyListener(this);
		clrButton.addKeyListener(this);
		negButton.addKeyListener(this);
		
	}
	 @Override
	    public void keyTyped(KeyEvent e) {
		 char keyChar = e.getKeyChar();
		    if (Character.isDigit(keyChar) || keyChar == '.') {
		        textfield.setText(textfield.getText().concat(String.valueOf(keyChar)));
		    } else if (keyChar == '=') {
		        num2 = Double.parseDouble(textfield.getText());
		        calculateResult();
		    } else if (keyChar == KeyEvent.VK_BACK_SPACE) {
		        String currentText = textfield.getText();
		        if (!currentText.isEmpty()) {
		            textfield.setText(currentText.substring(0, currentText.length() - 1));
		        }
		    } else if (keyChar == '*') { 
		        num1 = Double.parseDouble(textfield.getText());
		        operator = '*';
		        textfield.setText("");
		    }

	       
	        }
	            

	    private void calculateResult() {
	    	 switch (operator) {
	         case '+':
	             result = num1 + num2;
	             break;
	         case '-':
	             result = num1 - num2;
	             break;
	         case '*':
	             result = num1 * num2;
	             break;
	         case '/':
	             result = num1 / num2;
	             break;
	     }
	     textfield.setText(String.valueOf(result));
	     num1 = result;
	 	
	}
		@Override
	    public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_PLUS) {
		        num1 = Double.parseDouble(textfield.getText());
		        operator = '+';
		        textfield.setText("");
		        addButton.setBackground(Color.DARK_GRAY);
		    } else if (e.getKeyCode() == KeyEvent.VK_MINUS) {
		        num1 = Double.parseDouble(textfield.getText());
		        operator = '-';
		        textfield.setText("");
		        addButton.setBackground(Color.DARK_GRAY);
		    } else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
		        num1 = Double.parseDouble(textfield.getText());
		        operator = '*';
		        textfield.setText("");
		        addButton.setBackground(Color.DARK_GRAY);
		    } else if (e.getKeyChar() == '/') {
		        num1 = Double.parseDouble(textfield.getText());
		        operator = '/';
		        textfield.setText("");
		        addButton.setBackground(Color.DARK_GRAY);
		    }
	    	    }
	    	        
	    @Override
	    public void keyReleased(KeyEvent e) {
	    	   if (e.getKeyCode() == KeyEvent.VK_PLUS) {
	    	        addButton.setBackground(Color.ORANGE); 
	    	    } else if (e.getKeyCode() == KeyEvent.VK_MINUS) {
	    	        subButton.setBackground(Color.ORANGE); 
	    	    } else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
	    	        mulButton.setBackground(Color.ORANGE); 
	    	    } else if (e.getKeyChar() == '/') {
	    	        divButton.setBackground(Color.ORANGE); 
	    	    }
	    }

	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.frame.setVisible(true);
	    calc.frame.requestFocusInWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
					
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
					
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			
			}
					
		}
}