package KhiemNguyen;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class matrixView extends JFrame
/*
 * The main view for rows and cols input.
 * Math operator choices with save and read options
 */
{	
	JLabel lb1 = new JLabel("First Matrix");
	JLabel lb2 = new JLabel("Second Matrix");
	
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);
	JTextField tf4 = new JTextField(20);
	JTextField tf5 = new JTextField(20);
	
	//Buttons and combobox
	JButton b1 = new JButton("Reset");
	JButton b2 = new JButton("Create");
	JButton b3 = new JButton("Execute");
	JComboBox cbb = new JComboBox();
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel dataP = new JPanel(new GridLayout(6,2));
	
	//Read file bar
	JPanel inputFP = new JPanel(new GridLayout(1,3));
	JLabel inLabel = new JLabel("Filename");
	JTextField readTextfield = new JTextField(30);
	JButton readButton = new JButton("Read");
	
	//Save file bar
	JPanel outputFP = new JPanel(new GridLayout(1,3));
	JLabel outLabel = new JLabel("Filename");
	JTextField SaveTextfield = new JTextField(15);
	JButton saveButton = new JButton("Save");
	

public matrixView()
{   //General outline position
	setBounds(300,300,500,300);
    setTitle("Matrix Math Program");
	setLayout(new BorderLayout());
	  add(dataP,BorderLayout.CENTER);
	  add(inputFP,BorderLayout.NORTH);
	  add(outputFP,BorderLayout.SOUTH);
	  
	 //Set size of button and combo box 
	 b1.setPreferredSize(new Dimension(225, 30));  
	 b2.setPreferredSize(new Dimension(225, 30));  
	 b3.setPreferredSize(new Dimension(225, 30));  
	 cbb.setPreferredSize(new Dimension(225,30));
	
	 //Add panel, textfield, and button to desired position
	dataP.add(p1); p1.add(lb1); p1.add(lb2);
    dataP.add(p2); p2.add(tf1); p2.add(tf2);
    dataP.add(p3); p3.add(tf3); p3.add(tf4);
    dataP.add(p4); p4.add(b1); p4.add(b2);
    dataP.add(p5); p5.add(cbb); p5.add(b3);
    dataP.add(p6); p6.add(tf5);
    
    //Option list for combobox
	cbb.addItem("*Select*");
	cbb.addItem("Addition");
	cbb.addItem("Subtraction");
	cbb.addItem("Transpose");
	cbb.addItem("Multiplication");
	
	inputFP.setBackground(Color.CYAN);
	inputFP.add(inLabel);inputFP.add(readTextfield);inputFP.add(readButton);
	outputFP.add(outLabel);outputFP.add(SaveTextfield);outputFP.add(saveButton);
	outputFP.setBackground(Color.YELLOW);
	
	setVisible(true);
}
	
	//Main method for view, used to check output
  public static void main(String[ ] args)
  {    new matrixView ();  }	

}