package linear_algebra;

/**
 * This class models a square matrix using a 2d array 
 * of doubles. By definition, a square matrix must have
 * the same number of rows as it does columns.
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

}
