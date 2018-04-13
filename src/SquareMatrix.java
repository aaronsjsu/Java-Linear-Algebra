package linear_algebra;

/**
 * This class models a square matrix using a 2d array of doubles. 
 * By definition, a square matrix must have the same number of rows 
 * as it does columns.
 * 
 * @author Aaron Smith
 */
public class SquareMatrix extends Matrix {
	
	
	/**
	 * Constructs a SquareMatrix object with an initial 2d array.
	 * 
	 * @param squareMatrix The 2d array to use to represent the square matrix.
	 */
	public SquareMatrix(double[][] squareMatrix) {
		super(squareMatrix); // Must call constructor first.
		if (squareMatrix.length != squareMatrix[0].length) {
			throw new IllegalArgumentException("Matrix # of rows != # of columns");
		}
	}

	
	/**
	 * Returns the determinant of a square matrix.
	 * 
	 * @return The determinant of the square matrix.
	 */
	public double getDeterminant() {
		return this.getDeterminant(this.getMatrix());
	}
	
	
	/**
	 * This calculates and returns the determinant of a square matrix. Note that
	 * this method is private, it is only used in the no args getDeterminant() 
	 * method above. In order to get the determinant of an (n x n)-matrix, this
	 * method calls itself recursively in order to use a method of calculation 
	 * known as the Laplace expansion.
	 * 
	 * @param matrix The matrix to get the determinant of.
	 * @return The determinant.
	 */
	private double getDeterminant(double[][] matrix) {
		int size = matrix.length;
		double determinant = 0;
		if (size == 1) { // Base case for the recursion method
			return matrix[0][0];
		}
		for (int i = 0; i < size; i++) { // Loop through each item in the first row of matrix
			double[][] innerMatrix = new double[size - 1][size - 1];
			for (int j = 1; j < size; j++) { // Start at 1 to skip over first row of matrix 
				for (int k = 0; k < size; k++) {
					// We don't want the column or the row of matrix[0][i] in our innerMatrix,
					// so when k == i, we don't do anything, and when k > i or k < i, we adjust
					// values to fill innerMatrix correctly.
					if (k < i) {
						innerMatrix[j - 1][k] = matrix[j][k];
					} else if (k > i) {
						innerMatrix[j - 1][k - 1] = matrix[j][k];
					}
				}
			}
			// Pattern follows + - + - + ..., which explains Math.pow(-1, i)
			determinant += matrix[0][i] * Math.pow(-1, i) * getDeterminant(innerMatrix);
		}
		return determinant;
	}
	
	
	// TODO
	public SquareMatrix getInverse() {
		return null;
	}
}
