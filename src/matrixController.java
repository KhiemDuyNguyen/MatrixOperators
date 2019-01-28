package KhiemNguyen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class matrixController extends matrixView implements ActionListener
/*
 * Controller for the main view.
 */
{
	matrixModel m = new matrixModel(this);
public matrixController()
{
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	cbb.addActionListener(this);
	readButton.addActionListener(this);
	saveButton.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
	Object wb =  e.getSource(); 
	System.out.println("widget selected ");	
	if		(wb == b1 ) 		m.resetData();
	else if	(wb == b2 ) 		m.createMatrix();
	else if	(wb == b3 ) 		m.executeMatrix();
	else if	(wb == readButton)  m.readFile(); 
	else if	(wb == saveButton)  m.saveFile();  
}	
public static void main(String[ ] args)
{    new matrixController ();  }

}
