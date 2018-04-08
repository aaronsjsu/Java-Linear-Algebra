package linear_algebra;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tests various methods in the linear_algebra package.
 * 
 * @author Aaron Smith
 */
public class LinearAlgebraTester  {
	
	public static void main(String[] args) {
		
		// Tests the getReducedMatris() method. 
		/*
		ArrayList<AugmentedMatrix> augmentedMatrices = new ArrayList<AugmentedMatrix>();
		ArrayList<Matrix> matrixSolutions = new ArrayList<Matrix>(); // Stores the expected solutions of augmented matrices in above arraylist
		
		// Add some test cases
		augmentedMatrices.add(new AugmentedMatrix(new double[][] {{2,3,4,25},{1,1,2,11},{2,0,3,14}})); // x1 = 4, x2 = 3, x3 = 2
		matrixSolutions.add(new Matrix(new double[][] {{1,0,0,4},{0,1,0,3},{0,0,1,2}}));
		augmentedMatrices.add(new AugmentedMatrix(new double[][] {{1,2,3,11},{0,2,-1,8},{8,6,-2,-14},{1,2,-2,1}})); // x1 = -5, x2 = 5, x3 = 2
		matrixSolutions.add(new Matrix(new double[][] {{1,0,0,-5},{0,1,0,5},{0,0,1,2},{0,0,0,0}}));
		augmentedMatrices.add(new AugmentedMatrix(new double[][] {{0,0,0,0},{0,2,-1,-10},{0,6,2,0},{1,2,3,14}})); // x1 = 0, x2 = -2, x3 = 6
		matrixSolutions.add(new Matrix(new double[][] {{1,0,0,0},{0,1,0,-2},{0,0,1,6},{0,0,0,0}}));
		augmentedMatrices.add(new AugmentedMatrix(new double[][] {{0,2,-1,4},{0,6,2,2},{0,2,3,-4}})); // x2 = 1, x3 = -2
		matrixSolutions.add(new Matrix(new double[][] {{0,1,0,1},{0,0,1,-2},{0,0,0,0}}));
		augmentedMatrices.add(new AugmentedMatrix(new double[][] {{2,0,-1,4},{6,0,2,2},{2,0,3,-4}})); // x1 = 1, x3 = -2
		matrixSolutions.add(new Matrix(new double[][] {{1,0,0,1},{0,0,1,-2},{0,0,0,0}}));
		augmentedMatrices.add(new AugmentedMatrix(new double[][] {{1,2,3,11},{-2,-4,-6,8},{3,6,9,-14}})); // No solution
		matrixSolutions.add(new Matrix(new double[][] {{1,2,3,11},{0,0,0,30},{0,0,0,-47}}));
		augmentedMatrices.add(new AugmentedMatrix(new double[][] {{1,2,3,4,10},{3,2,1,2,8}})); // Infinite solutions
		matrixSolutions.add(new Matrix(new double[][] {{1,0,-1,-1,-1},{0,1,2,2.5,5.5}}));

		
		System.out.println("Reduced Matrices: "); 
		for (int i = 0; i < augmentedMatrices.size(); i++) { // Prints out each augmented matrix and it's expected values
			System.out.println("Got: ");
			augmentedMatrices.get(i).printReducedMatrix();
			System.out.println("Expected: ");
			matrixSolutions.get(i).printMatrix();
			//System.out.println("Is homogeneous: " + augmentedMatrices.get(i).isHomogeneous());
			//System.out.println("Has Infinite Solutions: " + augmentedMatrices.get(i).hasInfiniteSolutions());
			//System.out.println("Has No Solution: " + augmentedMatrices.get(i).hasNoSolution());
			//System.out.println("Has Only One Solution: " + augmentedMatrices.get(i).hasOneSolution());
			System.out.println("..........");
		}
		*/
		

		// Tests methods in the AugmentedMatrix class, these methods are now private 
		// because they are only used by the getReducedMatris() method in the AugmentedMatrix class
		/*
		AugmentedMatrix matrix1 = new AugmentedMatrix(new double[][] {{1,0,0,0},{0,1,0,0},{0,0,1,0}});
		
		System.out.println("---");
		System.out.println("Testing Various Methods: ");
		// Tests row addition
		double[][] matrixToAdd = new double[][] {{1,2,3},{3,2,1},{-1,-2,-3}};
		System.out.println("Testing Row Addition... Got:");
		System.out.println(Arrays.deepToString(matrix1.rowAddition(matrixToAdd, 0, 1, 2)));
		System.out.println("Expected: ");
		System.out.println(Arrays.deepToString(new double[][] {{1,2,3},{5,6,7},{-1,-2,-3}}));
		double[][] matrixToAdd2 = new double[][] {{1,2,3},{3,2,1},{-1,-2,-3}};
		System.out.println("Testing Row Addition... Got:");
		System.out.println(Arrays.deepToString(matrix1.rowAddition(matrixToAdd2, 0, 2, -1)));
		System.out.println("Expected: ");
		System.out.println(Arrays.deepToString(new double[][] {{1,2,3},{3,2,1},{-2,-4,-6}}));
		
		System.out.println("---");
		// Tests row scaling
		double[] rowToScale = new double[] {2,3,4};
		System.out.println("Testing Row Scaling... Got:");
		System.out.println(Arrays.toString(matrix1.rowScale(rowToScale, 2)));
		System.out.println("Expected: ");
		System.out.println(Arrays.toString(new double[] {1,1.5,2}));
		double[] rowToScale2 = new double[] {2,3,4};
		System.out.println("Testing Row Scaling... Got:");
		System.out.println(Arrays.toString(matrix1.rowScale(rowToScale2, .5)));
		System.out.println("Expected: ");
		System.out.println(Arrays.toString(new double[] {4,6,8}));
		
		System.out.println("---");
		// Tests row interchanging
		double[][] matrixToInterchange = new double[][] {{1,2,3},{3,2,1},{-1,-2,-3}};
		System.out.println("Testing Row Interchange... Got:");
		System.out.println(Arrays.deepToString(matrix1.rowInterchange(matrixToInterchange, 0, 2)));
		System.out.println("Expected: ");
		System.out.println(Arrays.deepToString(new double[][] {{-1,-2,-3},{3,2,1},{1,2,3}}));
		double[][] matrixToInterchange2 = new double[][] {{1,2,3},{3,2,1},{-1,-2,-3}};
		System.out.println("Testing Row Interchange... Got:");
		System.out.println(Arrays.deepToString(matrix1.rowInterchange(matrixToInterchange2, 1, 2)));
		System.out.println("Expected: ");
		System.out.println(Arrays.deepToString(new double[][] {{1,2,3},{-1,-2,-3},{3,2,1}}));
		
		System.out.println("---");
		// Tests arrayIsZero
		System.out.println("Testing arrayIsZero... Got:");
		System.out.println(matrix1.arrayIsZero(new double[]{0,0,0}));
		System.out.println(matrix1.arrayIsZero(new double[]{0,0,1}));
		System.out.println(matrix1.arrayIsZero(new double[]{0,0,0,0,0,0,0,0}));
		System.out.println("Expected: ");
		System.out.println(true);
		System.out.println(false);
		System.out.println(true);
				
		System.out.println("---");
		// Test restOfArrayIsZero
		System.out.println("Testing restOfArrayIsZero... Got:");
		System.out.println(matrix1.restOfArrayIsZero(new double[]{0,1,0,0,0}, 2));
		System.out.println(matrix1.restOfArrayIsZero(new double[]{0,0,0,0,1}, 2));
		System.out.println(matrix1.restOfArrayIsZero(new double[]{0,0,0,0,1,0,0,0,0}, 5));
		System.out.println("Expected: ");
		System.out.println(true);
		System.out.println(false);
		System.out.println(true);
		
		System.out.println("---");
		// Test moveRowToBottom
		System.out.println("Testing moveRowToBottom... Got:");
		System.out.println(Arrays.deepToString(matrix1.moveRowToBottom(new double[][]{{1,2,3},{0,0,0},{-1,-2,-3}}, 1)));
		System.out.println("Expected: ");
		System.out.println(Arrays.deepToString(new double[][]{{1,2,3},{-1,-2,-3},{0,0,0}}));
		System.out.println("Testing moveRowToBottom... Got:");
		System.out.println(Arrays.deepToString(matrix1.moveRowToBottom(new double[][]{{1,2,3},{0,0,0},{-1,-2,-3},{5,3,1}}, 2)));
		System.out.println("Expected: ");
		System.out.println(Arrays.deepToString(new double[][]{{1,2,3},{0,0,0},{5,3,1},{-1,-2,-3}}));
		
		System.out.println("---");
		// Test arrayIsInvalid
		System.out.println("Testing arrayIsInvalid... Got:");
		System.out.println(matrix1.arrayIsInvalid(new double[] {0,0,0,0}));
		System.out.println(matrix1.arrayIsInvalid(new double[] {0,0,0,1}));
		System.out.println(matrix1.arrayIsInvalid(new double[] {3,9,1,3,0}));
		System.out.println("Expected:");
		System.out.println("false");
		System.out.println("true");
		System.out.println("false");
		
		System.out.println("---");
		// Test arrayIsZero
		System.out.println("Testing arrayIsZero... Got:");
		System.out.println(matrix1.arrayIsZero(new double[] {0,0,0,0}));
		System.out.println(matrix1.arrayIsZero(new double[] {0,0,0,1}));
		System.out.println(matrix1.arrayIsZero(new double[] {3,9,1,3,0}));
		System.out.println("Expected:");
		System.out.println("true");
		System.out.println("false");
		System.out.println("false");
		*/
		
		// Tests the Vector class
		/*
		System.out.println("---");
		// Tests vectors and Matrix multiplyBy() method
		Vector v1 = new Vector(new double[] {1, 2, 3});
		Vector v2 = new Vector(new double[] {2, 1, 3});
		Vector v3 = new Vector(new double[] {3, 2, 1});
		Matrix m = new Matrix(new double[][] {{1,2,3},{4,5,6},{7,8,9}});
		System.out.println("Got: ");
		v1.printVector(m.multiplyBy(v1));
		System.out.println("Expected: ");
		v1.printVector(new double[] {14, 32, 50});
		System.out.println("Got: ");
		v2.printVector(m.multiplyBy(v2));
		System.out.println("Expected: ");
		v2.printVector(new double[] {13, 31, 49});
		System.out.println("Got: ");
		v3.printVector(m.multiplyBy(v3));
		System.out.println("Expected: ");
		v3.printVector(new double[] {10, 28, 46});
		ArrayList<Vector> vectors = new ArrayList<>();
		vectors.add(v1);
		vectors.add(v2);
		vectors.add(v3);
		System.out.println("Linear Independence: " + Vector.isLinearlyIndependent(vectors));
		*/
		
		// Tests the Matrix class
		/*
		System.out.println("---");
		// Tests Matrix multiplyBy() method
		Matrix m1 = new Matrix(new double[][] {{3,4,2}});
		Matrix m2 = new Matrix(new double[][] {{13,9,7,15},{8,7,4,6},{6,4,0,3}});
		System.out.println("Got: ");
		m1.printMatrix(m1.multiplyBy(m2));
		System.out.println("Expected: ");
		m1.printMatrix(new double[][] {{83,63,37,75}});
		m1.setMatrix(new double[][] {{-1,2,1},{0,3,-2}});
		m2.setMatrix(new double[][] {{3,4},{1,-1},{-1,2}});
		System.out.println("Got: ");
		m1.printMatrix(m1.multiplyBy(m2));
		System.out.println("Expected: ");
		m1.printMatrix(new double[][] {{-2,-4},{5,-7}});
		// Tests transpose()
		m1 = new Matrix(new double[][] {{5,4},{4,0},{7,10},{-1,8}});
		System.out.println("Got:");
		m1.printMatrix(m1.getTranspose());
		System.out.println("Expected:");
		m1.printMatrix(new double[][] {{5,4,7,-1},{4,0,10,8}});
		m2 = new Matrix(new double[][] {{1,2,0},{-1,3,4}});
		System.out.println("Got:");
		m2.printMatrix(m2.getTranspose());
		System.out.println("Expected:");
		m2.printMatrix(new double[][] {{1,-1},{2,3},{0,4}});
		*/
	}	
}
