package linear_algebra;

import java.util.ArrayList;

/**
 * This class is used to solve problems in linear algebra that
 * can currently be solved using this package. Use this class 
 * as an example/template.
 * 
 * @author Aaron Smith
 */
public class Solver {
	public static void main(String[] args) {
		
		// Creates an augmented matrix using double[][] array1
		double[][] array1 = new double[][] {{2,3,4,25}, // Solution set: x1 = 4, x2 = 3, x3 = 2
											{1,1,2,11},
											{2,0,3,14}}; // Could be any number of rows/columns long.
		AugmentedMatrix augMatrix1 = new AugmentedMatrix(array1); // Creates an AugmentedMatrix instance
		augMatrix1.printReducedMatrix(); // Prints the reduced matrix
		
		
		/*
		// If you wanted to store AugmentedMatrix objects in a list:
		ArrayList<AugmentedMatrix> augmentedMatrices = new ArrayList<AugmentedMatrix>(); // Create the list
		augmentedMatrices.add(augMatrix1); // Adds augmented matrix to the list
		// Then you could print each solution using a for loop
		for (AugmentedMatrix aM : augmentedMatrices) {
			aM.printReducedMatrix(); // Prints each solution in the list
		}
		*/
		
		
		// Creates a vector using double[] array2
		double[] array2 = new double[] {1, 
										2,
										3};
		Vector v1 = new Vector(array2); // Creates a Vector instance
		Matrix m1 = new Matrix(new double[][] {{1,2,3},{4,5,6},{7,8,9}}); // Creates a matrix instance
		double[] result = m1.multiplyBy(v1); // Multiplies the matrix by the vector, stores the answer in a double[]
		v1.printVector(result); // Prints the result 
		
	}
}