package KhiemNguyen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class matrixView2 extends JFrame 
/*
 * Views for display matrixes with their elements
 */
{
	
	//Button list for options
	JButton button1 = new JButton("Clear");
	JButton button2 = new JButton("Save");
	JButton button3 = new JButton("Open");
	JButton button4 = new JButton("CONFIRM");
	JTextField fileName = new JTextField(10);
	
	//2 dimensional TextField that represents matrix
	JTextField[][] tf = new JTextField[100][100];
	
	JPanel p1 = new JPanel();
	
	JPanel confirmBar = new JPanel (new GridLayout(1,1));
	JPanel optionBar = new JPanel (new GridLayout(1,4));
	
	public matrixView2(matrixClass myMatrix, char a)
	{
		//Get row and col of matrix that want to set a view
		int col = myMatrix.getLengthCol();
		int row = myMatrix.getLengthRow();
		
		JLabel[][] lb = new JLabel[row][col];
		JPanel[] p = new JPanel[row];
		JPanel dataP = new JPanel(new GridLayout(row+1,col+1));
		
		confirmBar.add(button4);
		optionBar.add(p1);
		
		//If char a = X, set up the view for matrix X
		if (a == 'X') {
			setBounds(550 - col*40 - 300,600,col*40 + 300,row*40 + 150);
			setTitle("Matrix X");
			p1.add(button1);
			p1.add(fileName);
			p1.add(button2);
			p1.add(button3);
			for (int i=0;i<row;i++)
			{
				p[i]= new JPanel();
				dataP.add(p[i]);
				for (int j=0;j<col;j++)
				{
					tf[i][j]= new JTextField(5);
					tf[i][j].setPreferredSize(new Dimension(30, 30));
					p[i].add(tf[i][j]);
				}
			}
			dataP.add(confirmBar);
		}
		
		//If char a = Y, set up the view for matrix Y
		else if (a == 'Y') {
			setBounds(550,600,col*40 + 300,row*40 + 150);
			setTitle("Matrix Y");
			p1.add(button1);
			p1.add(fileName);
			p1.add(button2);
			p1.add(button3);
			for (int i=0;i<row;i++)
			{
				p[i]= new JPanel();
				dataP.add(p[i]);
				for (int j=0;j<col;j++)
				{
					tf[i][j]= new JTextField(5);
					tf[i][j].setPreferredSize(new Dimension(30, 30));
					p[i].add(tf[i][j]);
				}
			}
			dataP.add(confirmBar);
		}
		
		//If char a = R, set up the view for matrix Result
		else if (a == 'R') {
			setBounds(1000,300,col*40 + 300,row*40 + 150);
			setTitle("Result Matrix");
			p1.add(fileName);
			p1.add(button2);
			for (int i=0;i<row;i++)
			{
				p[i]= new JPanel();
				dataP.add(p[i]);
				for (int j=0;j<col;j++)
				{
					tf[i][j]= new JTextField(5);
					tf[i][j].setPreferredSize(new Dimension(30, 30));
					p[i].add(tf[i][j]);
					tf[i][j].setText((myMatrix.getValue(i,j).toString()));
				}
			}
		}
		
		setLayout(new BorderLayout());
		add(dataP,BorderLayout.CENTER);
		add(optionBar,BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
