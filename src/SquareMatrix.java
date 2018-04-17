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
	
	
	/**
	 * This calculates and returns a matrix of minors. A matrix of minors is basically a
	 * matrix made up of determinates of inner matrices within the original matrix.
	 * 
	 * @return The matrix of minors as a double[][].
	 */
	public double[][] getMatrixOfMinors() {
		double[][] matrix = this.getMatrix();
		int size = matrix.length;
		double[][] matrixOfMinors = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// These first two loops (i and j) are to fill the matrixOfMinors.
				// The next two loops (k and c) are to fill the innerMatrix.
				double[][] innerMatrix = new double[size - 1][size - 1];
				for (int k = 0; k < size; k++) {
					for (int c = 0; c < size; c++) {
						// We don't want the column or the row of matrix[i][j] in our innerMatrix,
						// so when k == i, we don't do anything, and in other cases, we adjust
						// values to fill the innerMatrix correctly. Note that i and j represent 
						// the matrixOfMinors's rows and columns respectively, and k and c represent
						// the innerMatrix's rows and columns respectively.
						if (k < i && c < j) {
							innerMatrix[k][c] = matrix[k][c];
						} else if (k < i && c > j) {
							innerMatrix[k][c - 1] = matrix[k][c];
						} else if (k > i && c < j) {
							innerMatrix[k - 1][c] = matrix[k][c];
						} else if (k > i && c > j) {
							innerMatrix[k - 1][c - 1] = matrix[k][c];
						}
					}
				matrixOfMinors[i][j] = this.getDeterminant(innerMatrix);
				}
			}
		}
		return matrixOfMinors;
	}
	
	
	/**
	 * Calculates and returns a matrix of cofactors. This is essentially a matrix of minors,
	 * but certain values in the matrix are switched to negative, or positive if already negative.
	 * 
	 * @return The matrix of cofactors as a double[][].
	 */
	public double[][] getMatrixOfCofactors() {
		double[][] matrix = this.getMatrixOfMinors();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				// Use Math.pow() to decide which values become negative.
				matrix[i][j] = Math.pow(-1, i + j) * matrix[i][j];
			}
		}
		return matrix;
	}
	
	
	/**
	 * Calculates and returns the adjoint of a matrix. This is essentially a transposed
	 * matrix of cofactors. 
	 * 
	 * @return The adjoint of a matrix.
	 */
	public double[][] getAdjoint() {
		return new SquareMatrix(this.getMatrixOfCofactors()).getTranspose();
	}
	

	/**
	 * Calculates and returns the inverse of a square matrix. It does this by multiplying
	 * the adjoint by 1/determinant, which will equal the inverse as long as the determinant
	 * is not equal to 0. 
	 * 
	 * @return The inverse of a matrix.
	 */
	public double[][] getInverse() {
		double determinant = this.getDeterminant();
		// If determinant is zero, inverse does not exist.
		if (determinant == 0) {
			return null;
		}
		return new SquareMatrix(this.getAdjoint()).multiplyBy(1/determinant);
	}

}
