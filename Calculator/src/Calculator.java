import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class Calculator implements ActionListener{
	
	JFrame frame;		// Creating a frame using JFrame
	JTextField textfield;	// Creating a text field area in the frame
	JButton[] numberButtons = new JButton[10];		//create an array for numbers in the calculator
	JButton[] funcButtons = new JButton[9];	// creating an array for function buttons
	JButton addButton, subButton, divButton, mulButton;		// Declaring the function button names
	JButton decButton, equButton, clrButton, delButton, negButton;		
	JPanel panel;		// Declaring the panel in the frame
	
	
	
	//creating the font and bold texture with size
	Font font = new Font("Ink Free", Font.BOLD, 30);
	
	
	//Declaring the variables to store the data which we enter
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	
	//creating an constructor
	Calculator(){
		
		// Call the frame in constructor and name it.
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		
		
		//creating the text field with desired bounds like x, y, width, height 
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(font);
		textfield.setEditable(false);
		
		//Adding symbols to the declared buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
		
		//Adding in to the function button array
		funcButtons[0] = addButton;
		funcButtons[1] = subButton;
		funcButtons[2] = mulButton;
		funcButtons[3] = divButton;
		funcButtons[4] = decButton;
		funcButtons[5] = equButton;
		funcButtons[6] = delButton;
		funcButtons[7] = clrButton;
		funcButtons[8] = negButton;
		
		
		// for loop to add action and font to function buttons
		for(int i = 0; i < 9; i++)
		{
			funcButtons[i].addActionListener(this);
			funcButtons[i].setFont(font);
			funcButtons[i].setFocusable(false);
			//System.out.println(funcButtons[i]);
		}
		
		
		// for loop to add numbers, actions and font to number buttons
		for(int i = 0; i < 10; i++)
		{
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font);
			numberButtons[i].setFocusable(false);
			//System.out.println(numberButtons[i]);
		}
		
		
		//setting the bounds to extra buttons
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);
		
		
		//calling the panel and declare it
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(Color.GRAY);
		
		
		//Adding all buttons to the panel
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
		panel.add(divButton);
		panel.add(equButton);
		
		
		
		//finally add all things to the frame
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
	}

	
	
	//overridden method from the action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 10; i++)
		{
			if(e.getSource() == numberButtons[i])
			{
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		
		if(e.getSource() == decButton)
		{
			textfield.setText(textfield.getText().concat("."));
		}
		
		
		if(e.getSource() == addButton)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		
		if(e.getSource() == subButton)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		
		if(e.getSource() == mulButton)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource() == divButton)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		
		if(e.getSource() == equButton)
		{
			num2 = Double.parseDouble(textfield.getText());
			
			
			
			//using switch case for the logic
			switch(operator)
			{
			
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
		
		
		if(e.getSource() == clrButton)
		{
			textfield.setText("");
		}
		
		if(e.getSource() == delButton)
		{
			String s = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < s.length()-1; i++)
			{
				textfield.setText(textfield.getText() + s.charAt(i));
			}
		}
		
		if(e.getSource() == negButton)
		{
			
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
		
		
	}
	

}
