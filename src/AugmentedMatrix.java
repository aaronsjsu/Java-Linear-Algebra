package linear_algebra;

/**
 * This class models an augmented matrix using a 2d array 
 * of doubles. The last column in the 2d array represents
 * the right hand portion of a typical augmented matrix.
 * This class notably provides a method to reduce the 
 * matrix into reduced row echelon form.
 * 
 * @author Aaron Smith
 */
public class AugmentedMatrix extends Matrix {
	
	/**
	 * Constructs an AugmentedMatrix object with an initial 2d array.
	 * 
	 * @param augmentedMatrix The 2d array to use to represent the augmented matrix.
	 */
	public AugmentedMatrix(double[][] augmentedMatrix) {
		super(augmentedMatrix);
	}

	/**
	 * Checks if a given array, in this case a row or a column, is made up of all zeros.
	 * 
	 * @param array The array (row or column) to check.
	 * @return True if all values in array is zero, else it returns false.
	 */
	public boolean arrayIsZero(double[] array) {
		for (double value : array) {
			if (value != 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if the rest of a given array starting from an index is made up of all zeros.
	 * 
	 * @param column The column/array to test.
	 * @param index The index in the array indicating where to start searching for zeros.
	 * @return True if the rest of the array is made up of all zeros, otherwise returns false.
	 */
	public boolean restOfArrayIsZero(double[] column, int index) {
		for (int i = index; i < column.length; i++) {
			if (column[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a row in a matrix is invalid. This tests if the row is made up of zeros except
	 * the rightmost value isn't zero. If this is the case, then the method returns false. In linear
	 * algebra, this is testing if the augmented matrix is inconsistent.
	 * 
	 * @param row The row/array from the matrix to test.
	 * @return True if invalid, false if not invalid.
	 */
	public boolean arrayIsInvalid(double[] row) {
		int numberOfZeros = 0;
		for (int i = 0; i < row.length; i++) {
			if (row[i] == 0) {
				numberOfZeros++;
			} else if (i == row.length - 1 && numberOfZeros == row.length -1) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This moves a row to the bottom of a matrix.
	 * 
	 * @param matrix The matrix to perform the operation on.
	 * @param row The index of the row to move to the bottom.
	 * @return The changed matrix.
	 */
	public double[][] moveRowToBottom(double[][] matrix, int row) {
		if (row >= matrix.length) {
			throw new IllegalArgumentException("Row does not exist");
		} else if (row == matrix.length - 1) { //Checks if row is already at the bottom of matrix.
			return matrix;
		}
		double[] rowToMove = matrix[row];
		for (int i = 0; i < matrix.length - 1; i++) {
			double[] currentRow = matrix[i];
			if (rowToMove == currentRow) {
				matrix = this.rowInterchange(matrix, i, i + 1);
			}
		}
		return matrix;
	}
	
	/**
	 * This method scales a row so that it's leading number is a 1.
	 * In linear algebra, this is a row operation that is equivalent to
	 * multiplying an entire row by a scalar. It is written like: (scalar)rowX
	 * 
	 * @param row The row to scale.
	 * @param numberToReduceBy The scale to reduce the row by.
	 * @return The scaled row.
	 */
	public double[] rowScale(double[] row, double numberToReduceBy) {
		if (numberToReduceBy == 0) {
			throw new IllegalArgumentException("Can't reduce/divide by zero");
		}
		for (int i = 0; i < row.length; i++) {
			row[i] = row[i] / numberToReduceBy;
		}
		return row;
	}
	
	/**
	 * This method switches two rows with each other. In linear algebra, this is
	 * a row operation that is written like: rowX <-> rowY.
	 * 
	 * @param matrix The matrix to edit.
	 * @param row1 The index of the first row to switch.
	 * @param row2 The index of the second row to switch.
	 * @return The matrix with two rows interchanged.
	 */
	public double[][] rowInterchange(double[][] matrix, int row1, int row2) {
		if (row1 >= matrix.length || row2 >= matrix.length) {
			throw new IllegalArgumentException("Row does not exist");
		}
		double[] placeHolder = matrix[row1];
		matrix[row1] = matrix[row2];
		matrix[row2] = placeHolder;
		return matrix;
	}

	/**
	 * This method takes a row, multiplies it by some factor, and then adds it to 
	 * another row in order to transform that other row. In linear algebra, this 
	 * is a row operation that is written like: (scalar)rowX + rowY -> rowY.
	 * 
	 * @param matrix The matrix to edit.
	 * @param rowX The first row, multiplied by a scalar and added to second row.
	 * @param rowY The second row, which is the only the row to be changed in the matrix.
	 * @param scalar The scalar to be multiplied by the first row.
	 * @return Returns the edited matrix.
	 */
	public double[][] rowAddition(double[][] matrix, int rowX, int rowY, double scalar) {
		if (rowX >= matrix.length || rowY >= matrix.length) { //Checks if rowX/rowY are bigger than matrix size
			throw new IllegalArgumentException("Row does not exist");
		}
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[rowY][i] += matrix[rowX][i] * scalar; //(scalar)rowX + rowY -> rowY
		}
		return matrix;
	}
	
	/**
	 * This method reduces the matrix into reduced row echelon form using the 
	 * Gauss-Jordan Elimination Method. It does this by looping over every value
	 * in the augmented matrix and editing it in the appropriate way by using 
	 * various methods defined in this class.
	 * 
	 * @return The reduced matrix.
	 */
	public double[][] getReducedMatrix() {
		double[][] matrix = super.getMatrix();
		double[][] reducedMatrix = new double[matrix.length][];
		for (int i = 0; i < matrix.length; i ++) { //This is to make a clone of the matrix and call it reducedMatrix
			reducedMatrix[i] = matrix[i].clone();  //so that this method doesn't edit the original matrix.
		}
		int rowsOfZero = 0; //Keeps track of how many rows of all zeros there are
		int nonPivotColumns = 0; //Keeps track of columns without pivots
		
		for (int i = 0; i < reducedMatrix[0].length - 1; i++) { //Loops through each column except very last
			
			double[] column = super.getColumn(reducedMatrix, i); //Gets the current column
			if (this.arrayIsZero(column) || restOfArrayIsZero(column, i)) { //Handles non pivot columns
				//nonPivotColumns++;
				continue;
			} 
			
			for (int j = 0; j < reducedMatrix.length; j++) { //Loops through each row
				
				double[] row = super.getRow(reducedMatrix, j); //Gets the current row
				double value = reducedMatrix[j][i]; //Current value
				if (i == j + nonPivotColumns) { //Handles a pivot coordinate
					if (value != 0) { //Handles a found pivot
						reducedMatrix[j] = this.rowScale(row, value); //Replaces row with edited row
						for (int k = 0; k < j; k++) { //Now that the pivot value is found, make all values above it in the column equal zero
							double currentValue = reducedMatrix[k][i];
							if (currentValue != 0) { //Makes value equal to zero if not already
								reducedMatrix = this.rowAddition(reducedMatrix, j, k, -currentValue); //Adds pivot row to make value equal zero
							}
						}
					} else {
						for (int k = j; k < column.length; k++) {
							if (column[k] != 0) { //Find next non zero value in column
								reducedMatrix = this.rowInterchange(reducedMatrix, j, k); //Switch current row with row with non zero value
								j -= 1; //Return to same row on next loop
							}
						}
					}
				} else if (i < j + nonPivotColumns) { //Handles values below the pivot in the column
					if (value != 0) { //Makes value equal to zero if not already
						reducedMatrix = this.rowAddition(reducedMatrix, i + nonPivotColumns, j, -value); //Adds pivot row to current row to make value equal zero
					}
				}
			}
		}
		
		for (int i = 0; i < reducedMatrix.length; i++) { //This is to move all rows of zeros to the bottom
			for (int j = 0; j < reducedMatrix[0].length; j++) { //This is to get rid of -0.0 in the matrix
				if (reducedMatrix[i][j] == 0 || Math.abs(reducedMatrix[i][j]) < .000001) { //Gets rid of -0.0 and values less than .000001
					reducedMatrix[i][j] = 0; 
				}
			}
			double[] row = super.getRow(reducedMatrix, i);
			if (this.arrayIsZero(row) && i <= reducedMatrix.length - 1 - rowsOfZero) {
				reducedMatrix = this.moveRowToBottom(reducedMatrix, i);
				rowsOfZero++; //Increment counter
				i--; //Return to same row on next loop
			}
		}
		
		return reducedMatrix;
	}
	
	/**
	 * Prints out a reduced matrix in an easily readable format.
	 */
	public void printReducedMatrix() {
		super.printMatrix(this.getReducedMatrix());
	}
	
}
