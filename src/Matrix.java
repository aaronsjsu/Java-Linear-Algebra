package linear_algebra;

import java.util.Arrays;

/**
 * This class models a mathematical matrix using a 2d array 
 * of doubles. It provides basic methods to interact with 
 * the matrix.
 * 
 * @author Aaron Smith
 */
public class Matrix {
	
	private double[][] matrix;
	
	
	/**
	 * Constructs a matrix object.
	 * 
	 * @param matrix The 2d array to use that represents the matrix.
	 */
	public Matrix(double[][] matrix) {
		this.matrix = matrix;
	}
	
	
	/**
	 * Returns the matrix that belongs to the object.
	 * 
	 * @return The matrix to return.
	 */
	public double[][] getMatrix() {
		return matrix;
	}
	
	
	/**
	 * Sets the matrix to equal a new matrix.
	 * 
	 * @param matrix The 2d array to use that represents the new matrix.
	 */
	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}
	
	
	/**
	 * Gets a value in the matrix at location row, col.
	 * 
	 * @param row The row to get the value from.
	 * @param col The column to get the value from.
	 * @return The value to return.
	 */
	public double getValue(int row, int col) {
		if (row >= matrix.length || col >= matrix[0].length) {
			throw new IllegalArgumentException("Column/Row does not exist");
		}
		return matrix[row][col];
	}
	
	
	/**
	 * Sets a value in the matrix at location row, col.
	 * 
	 * @param row The row where the value to reset is located.
	 * @param col The column where the value to reset is located.
	 * @param value The new value.
	 */
	public void setValue(int row, int col, double value) {
		if (row >= matrix.length || col >= matrix[0].length) {
			throw new IllegalArgumentException("Column/Row does not exist");
		}
		matrix[row][col] = value;
	}
	
	
	/**
	 * This method returns the whole column in a given matrix.
	 * 
	 * @param matrix The matrix to get a column from.
	 * @param columnNumber The index of the column to return.
	 * @return Returns an array of doubles that represents the desired column.
	 */
	public double[] getColumn(double[][] matrix, int columnNumber) {
		if (columnNumber >= matrix[0].length) {
			throw new IllegalArgumentException("Column " + columnNumber + " does not exist");
		}
		double[] column = new double[matrix.length];
		for (int i = 0; i < column.length; i++) {
			column[i] = matrix[i][columnNumber];
		}
		return column;
	}
	
	
	/**
	 * This method returns the whole row in a given matrix.
	 * 
	 * @param matrix The matrix to get a row from.
	 * @param rowNumber The index of the row to return.
	 * @return Returns an array of doubles that represents the desired row.
	 */
	public double[] getRow(double[][] matrix, int rowNumber) {
		if (rowNumber >= matrix.length) {
			throw new IllegalArgumentException("Column " + rowNumber + " does not exist");
		}
		return matrix[rowNumber].clone(); // Returns a new array by cloning the original
	}
	
	
	/**
	 * This multiplies the matrix by a vector, and returns the resulting vector as a double[].
	 * 
	 * @param v Vector to multiply by the matrix.
	 * @return The resulting vector as a double[]
	 */
	public double[] multiplyBy(Vector v) {
		if (this.matrix[0].length != v.getVector().length) {
			throw new IllegalArgumentException("Number of columns in matrix != number of rows in vector");
		}
		double[] result = new double[this.matrix.length];
		double value = 0;
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				value += matrix[i][j] * v.getVector()[j];
			}
			result[i] = value;
			value = 0;
		}
		return result;
	}
	
	
	/**
	 * This multiplies the matrix by another matrix, and returns the resulting matrix as a double[][].
	 * Note that the number of columns in the first matrix has to equal the number of rows in the second matrix.
	 * 
	 * @param m Other matrix to multiply by.
	 * @return The resulting matrix as a double[][].
	 */
	public double[][] multiplyBy(Matrix m) {
		double[][] otherMatrix = m.getMatrix();
		// Multiplying an (m x n)-matrix by an (n x p)-matrix yields a (m x p)-matrix. Check to 
		// make sure that is the case.
		if (this.matrix[0].length != otherMatrix.length) {
			throw new IllegalArgumentException("Number of columns in matrix 1 != number of rows in matrix 2");
		}
		double[][] result = new double[this.matrix.length][otherMatrix[0].length];
		double value = 0;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				for (int k = 0; k < this.matrix[0].length; k++) {
					value += this.matrix[i][k] * otherMatrix[k][j];
				}
				result[i][j] = value;
				value = 0;
			}
		}
		return result;
	}
	
	
	/**
	 * Returns the transpose of a matrix, which simply means that each row
	 * in the matrix is rotated to become a column, and that is the matrix's transpose.
	 * 
	 * @return The resulting matrix as a double[][].
	 */
	public double[][] getTranspose() {
		double[][] matrix = this.getMatrix();
		double[][] result = new double[matrix[0].length][matrix.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = matrix[j][i]; // Transposes...
			}
		}
		return result;
	}
	
	
	/**
	 * This prints the given matrix in an easily readable format.
	 * 
	 * @param matrix The matrix to print.
	 */
	public void printMatrix(double[][] matrix) {
		System.out.println(" ----- ");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println(" ----- ");
	}
	
	
	/**
	 * Overloads printMatrix() method to allow for printing without providing an argument.
	 * Prints out the default matrix.
	 */
	public void printMatrix() {
		this.printMatrix(this.matrix);
	}
	
}
