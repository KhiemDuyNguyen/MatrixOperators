package KhiemNguyen;

import java.io.Serializable;

public class matrixClass implements Serializable
/*
 * Matrix class that has contribute is int rows, int cols, and Double[][] matrix
 * Has constructor as row and col number.
 */
{
	private int rows, cols;
	private Double[][] matrix;
	
	matrixClass(int row, int col) {
		this.rows = row;
		this.cols = col;
		matrix = new Double[row][col];
	}
	
	//Get value of a specific [row][col] position of matrix
	public Double getValue(int rows, int cols) {
		return matrix[rows][cols];
	}
	
	//Set value of a specific [row][col] position of matrix
	public void setValue(int rows, int cols, double value) {
		matrix[rows][cols] = value;
	}
	
	public int getLengthRow() {
		return rows;
	}
	
	public int getLengthCol() {
		return cols;
	}
	
	//Add two matrices together. Return a new matrix
	public matrixClass addMatrix(matrixClass matrix2) {
		boolean valid = (this.getLengthRow() == matrix2.getLengthRow()) | 
						(this.getLengthCol() == matrix2.getLengthCol());
		if (valid) {
			int row = this.getLengthRow();
			int col = this.getLengthCol();
			matrixClass resultMatrix = new matrixClass(row, col);
			for (int i = 0; i < row; i++) 
				for (int j = 0; j < col; j++)
					resultMatrix.setValue(i,j,this.getValue(i,j) + matrix2.getValue(i,j));
			return resultMatrix;		
		}
		else {
			throw new IllegalArgumentException("Same rows or columns needed for Add or Subtraction");
		}	
 	}
	
	//Subtract two matrices together. Return a new matrix
	public matrixClass subMatrix(matrixClass matrix2) {
		boolean valid = (this.getLengthRow() == matrix2.getLengthRow()) | 
						(this.getLengthCol() == matrix2.getLengthCol());
		if (valid) {
			int row = this.getLengthRow();
			int col = this.getLengthCol();
			matrixClass resultMatrix = new matrixClass(row, col);
			for (int i = 0; i < row; i++) 
				for (int j = 0; j < col; j++)
					resultMatrix.setValue(i,j,this.getValue(i,j) - matrix2.getValue(i,j));
			return resultMatrix;		
		}
		else {
			throw new IllegalArgumentException("Same rows or columns needed for Add or Subtraction");
		}	
 	}
	
	//Transpose the first matrix. Return a new matrix
	public matrixClass transMatrix() {
		int row = this.getLengthRow();
		int col = this.getLengthCol();
		matrixClass resultMatrix = new matrixClass(col, row);
		for (int i = 0; i < col; i++)
			for (int j = 0; j < row; j++)
				resultMatrix.setValue(i,j,this.getValue(j,i));
		return resultMatrix;
	}
	
	//Multiply two matrices together. Return a new matrix
	public matrixClass multiMatrix(matrixClass matrix2) {
		int row1 = this.getLengthRow();
		int col2 = matrix2.getLengthCol();
		boolean valid = (this.getLengthRow() == matrix2.getLengthCol()) | 
						(this.getLengthCol() == matrix2.getLengthRow());
		if (valid) {
			matrixClass resultMatrix = new matrixClass(row1, col2);
			for (int i = 0; i < row1; i++)
				for (int j = 0; j < col2; j++) {
					Double sum = 0.0;
					for (int k = 0; k < this.getLengthCol(); k ++) {
						sum += this.getValue(i,k)*matrix2.getValue(k,j);
					}
					resultMatrix.setValue(i,j,sum);
				}
		return resultMatrix;	
		}
		else
			throw new IllegalArgumentException("Illegal matrixes dimensions.");
	}
}
















