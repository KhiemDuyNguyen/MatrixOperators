package KhiemNguyen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class matrixController2 extends matrixView2 implements ActionListener
/*
 * Controller for the second view (of matrix X).
 */
{
	private matrixModel m = new matrixModel(this);
public matrixController2(matrixClass myMatrix, char a)
{
	super(myMatrix, a);
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	button4.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
	Object wg =  e.getSource(); 
	System.out.println("widget selected ");	
	if		(wg == button1 ) 		m.clearData2();
	else if	(wg == button2 ) 		m.saveMatrix2();
	else if	(wg == button3 ) 		m.openMatrix2();
	else if	(wg == button4 ) 		m.confirmMatrix2();
}	
}