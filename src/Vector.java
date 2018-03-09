package linear_algebra;

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
	 * Prints the vector in an easily readable format. Overloads previous method to
	 * allow for printing the vector already created.
	 */
	public void printVector() {
		this.printVector(this.vector);
	}
	
}
