package linear_algebra;

import java.util.ArrayList;

/**
 * This class models a vector (only column vectors) by 
 * using an array of doubles to represent vector values. The vector
 * can then be used to solve problems in Linear Algebra.
 * 
 * @author Aaron Smith
 */
public class Vector {
	
	private double[] vector;
	
	
	/**
	 * Constructs a Vector object.
	 * 
	 * @param vector The double[] array used to represent the vector.
	 */
	public Vector(double[] vector) {
		this.vector = vector;
	}
	
	
	/**
	 * Returns the vector instance variable.
	 * 
	 * @return Vector represented as a double[].
	 */
	public double[] getVector() {
		return vector;
	}
	
	
	/**
	 * Sets the vector to equal a different double[].
	 * 
	 * @param vector The new double[] to represent the vector.
	 */
	public void setVector(double[] vector) {
		this.vector = vector;
	}
	
	
	/**
	 * Prints the vector in an easily readable format.
	 * 
	 * @param vector The double[] to print.
	 */
	public void printVector(double[] vector) {
		System.out.println(" ----- ");
		for (int i = 0; i < vector.length; i++) {
			System.out.println("[" + vector[i] + "]");
		}
		System.out.println(" ----- ");
	}
	
	
	/**
	 * Checks if an ArrayList of Vector objects is linearly independent. In Linear Algebra,
	 * this is found by putting column vectors into an augmented matrix consisting of a 
	 * homogeneous system of equations and checking whether or not that augmented matrix 
	 * has more than one solution. If it doesn't, then those vectors are linearly independent. 
	 * 
	 * @param vectors An ArrayList containing Vector objects of equivalent lengths.
	 * @return True if set is linearly independent, false if not.
	 */
	public static boolean isLinearlyIndependent(ArrayList<Vector> vectors) {
		if (vectors.isEmpty()) { // Returns false for an empty ArrayList
			return false;
		} else if (vectors.size() == 1) { // Handles an ArrayList of size 1
			for (double value : vectors.get(0).getVector()) {
				if (value != 0) {
					return false;
				}
			}
		}
		for (int i = 0; i < vectors.size() - 1; i++) { // Makes sure each vector is the same size
			if (vectors.get(i).getVector().length != vectors.get(i+1).getVector().length) {
				throw new IllegalArgumentException("Not all vectors are the same length");
			}
		}
		double[][] matrix = new double[vectors.get(0).getVector().length][vectors.size() + 1];
		for (int i = 0; i < matrix.length; i++) { // Fill a double[][] properly with each vector representing a column
			for (int j = 0; j < matrix[0].length; j++) {
				if (j == matrix[0].length - 1) { // Fill the last row with zeros
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = vectors.get(j).getVector()[i];
				}
			}
		}
		AugmentedMatrix augMatrix = new AugmentedMatrix(matrix);
		// Check if augMatrix has infinite solutions (which means not linearly independent)
		if (augMatrix.hasInfiniteSolutions()) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Prints the vector in an easily readable format. Overloads previous method to
	 * allow for printing the vector already created.
	 */
	public void printVector() {
		this.printVector(this.vector);
	}
	
}
