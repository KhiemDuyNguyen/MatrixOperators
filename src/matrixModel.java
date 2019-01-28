package KhiemNguyen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class matrixModel 
/*
 * Model class controls all the buttons from all views.
 * Execute the right method when a button was clicked.
 */
{
	
//Controller for each view
private matrixController c;		//Main view
private matrixController2 c2;	//Matrix X
private matrixController3 c3;	//Matrix Y
private matrixController4 c4;	//Matrix result

public matrixModel(matrixController fromC) { c= fromC; }
public matrixModel(matrixController2 fromC2) { c2= fromC2; }
public matrixModel(matrixController3 fromC3) { c3= fromC3; }
public matrixModel(matrixController4 fromC4) { c4= fromC4; }

public static matrixClass resultMatrix;
public matrixView2 resultDisplay;

//Rows and cols for matrixX and matrixY
public static int Row1, Row2, Col1, Col2;
public static matrixClass Matrix1, Matrix2;

//READ SAVE FILE OF MATRIX HERE
public matrixClass[] matrixData = new matrixClass[50];
public PerMatrix persistence = new PerMatrix(matrixData);
public int numStus = 0;

public void readFile() {
	//UNUSED: READFILE BUTTON FOR MAIN VIEW
	System.out.println("file opened as an object");
}

public void saveFile() {
	//UNUSED: SAVEFILE BUTTON FOR MAIN VIEW
	System.out.println("file saved as object");
}

public void resetData() {
	//RESET DATA IN ROW AND COL WHEN "RESET" BUTTON IS CLICKED
 	c.tf1.setText("");
	c.tf2.setText("");
	c.tf3.setText("");
	c.tf4.setText("");
}

public void createMatrix() {
	//IF VALID, CREATE MATRIXES VIEW FOR MATRIX X AND MATRIX Y FROM USER'S INPUT FOR ROW AND COL
	String row1= c.tf1.getText().trim();
	String row2= c.tf2.getText().trim();
	String col1= c.tf3.getText().trim();
	String col2= c.tf4.getText().trim();
	boolean valid = true;
	try {
	Row1=Integer.parseInt(row1);
	Row2=Integer.parseInt(row2);
	Col1=Integer.parseInt(col1);
	Col2=Integer.parseInt(col2);
	}
	catch (NumberFormatException e) {
		System.out.println("Please input Integer for row and col!");
		resetData();
		valid = false;
		}
	
	//IF VALID, CREATE 2 MATRIXES
	if (valid) {
	Matrix1 = new matrixClass(Row1,Col1);
	Matrix2 = new matrixClass(Row2,Col2);
	matrixController2 myMatrix1 = new matrixController2(Matrix1, 'X');
	matrixController3 myMatrix2 = new matrixController3(Matrix2, 'Y');
	}
}

public void executeMatrix() {
	//DEPEND ON CHOICE IN COMBOBOX, EXECUTE THE RIGHT MATH OPERATOR IF VALIDATED
	int option = c.cbb.getSelectedIndex();
	boolean valid = true;
	switch (option) {
	case 0: System.out.println("Please select option to execute!"); break;
	
	case 1: 
		try {
		resultMatrix = Matrix1.addMatrix(Matrix2);
		} catch (IllegalArgumentException e) {
			System.out.println("Input same Rows and Cols for Add or Subtraction and hit CONFIRM button!");
			valid = false;	
		};
		break;
	case 2:
		try {
		resultMatrix = Matrix1.subMatrix(Matrix2);	
		} catch (IllegalArgumentException e) {
			System.out.println("Input same Rows and Cols for Add or Subtraction and hit CONFIRM button!");
			valid = false;	
		};
		break;
	case 3:
		try {
		resultMatrix = Matrix1.transMatrix();
		} catch (IllegalArgumentException e) {
			System.out.println("Input data for matrix X and hit CONFIRM button!");
			valid = false;	
		};
		break;
	case 4:
		try {
		resultMatrix = Matrix1.multiMatrix(Matrix2);
		} catch (IllegalArgumentException e) {
			System.out.println("Input legal matrixes dimensions for multiplication and hit CONFIRM button!.");
			valid = false;	
		};
		break;
	}
	if (valid) {
		matrixController4 resultDisplay =  new matrixController4(resultMatrix, 'R');
	}
}

public void clearData2() {
	for (int i = 0; i< Row1; i++)
		for (int j = 0; j < Col1; j++) {
			c2.tf[i][j].setText("");
		}
}

public void saveMatrix2() {
	matrixData[numStus] = Matrix1;
	persistence.saveFile(c2.fileName.getText());
}

public void openMatrix2() {
	matrixData = persistence.readFile(c2.fileName.getText());
	Matrix1 = matrixData[0];
	matrixController2 savedMatrix = new matrixController2(Matrix1, 'X');
	for (int i = 0; i < Matrix1.getLengthRow(); i++)
		for (int j = 0; j < Matrix1.getLengthCol(); j++)
			savedMatrix.tf[i][j].setText((Matrix1.getValue(i,j).toString()));
}

public void confirmMatrix2() {
	//Confirm matrixes data and save in Matrix1
	for (int i = 0; i< Row1; i++) {
		boolean valid = true;
		for (int j = 0; j < Col1; j++) {		
			
			try {
			String strNumb = c2.tf[i][j].getText().trim();
			Double eleMatrix = Double.parseDouble(strNumb);
			Matrix1.setValue(i,j, eleMatrix);
			}
			catch (NumberFormatException e) {
				System.out.println("Please input number for Matrix elements");
				clearData2();
				valid = false;
				break;
			}	
		}
	if (!valid)
		break;
	}
}

public void clearData3() {
	for (int i = 0; i< Row2; i++)
		for (int j = 0; j < Col2; j++) {
			c3.tf[i][j].setText("");
		}
}
public void saveMatrix3() {
	matrixData[numStus] = Matrix2;
	persistence.saveFile(c3.fileName.getText());
}

public void openMatrix3() {
	matrixData = persistence.readFile(c3.fileName.getText());
	Matrix2 = matrixData[0];
	matrixController3 savedMatrix = new matrixController3(Matrix2, 'Y');
	for (int i = 0; i < Matrix2.getLengthRow(); i++)
		for (int j = 0; j < Matrix2.getLengthCol(); j++)
			savedMatrix.tf[i][j].setText((Matrix2.getValue(i,j).toString()));
}

public void confirmMatrix3() {
	//Confirm matrixes data and save in Matrix2
	for (int i = 0; i< Row2; i++) {
		boolean valid = true;
		for (int j = 0; j < Col2; j++) {
			try {
			String strNumb = c3.tf[i][j].getText().trim();
			Double eleMatrix = Double.parseDouble(strNumb);
			Matrix2.setValue(i,j, eleMatrix);
			}
			catch (NumberFormatException e) {
				System.out.println("Please input number for Matrix elements");
				clearData3();
				valid = false;
				break;
			}
		}
		if (!valid)
			break;
	}
}
public void saveMatrix4() {
	//Save button for matrix Result
	matrixData[numStus] = resultMatrix;
	persistence.saveFile(c4.fileName.getText());
}
}



