package KhiemNguyen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class matrixController4 extends matrixView2 implements ActionListener
/*
 * Controller for the forth view (of matrix Result).
 */
{
	private matrixModel m = new matrixModel(this);
public matrixController4(matrixClass myMatrix, char a)
{
	super(myMatrix, a);
	button2.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
	Object wgn =  e.getSource(); 
	System.out.println("widget selected ");	
	if		(wgn == button2 ) 		m.saveMatrix4();

}	
}