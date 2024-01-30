import java.util.Random;

public class MatrixMultiplicationDouble_a {
	public static void main(String[] args) {
        // Define matrix sizes
        int rowsA = 1201, colsA = 1202; 
        int rowsB = colsA, colsB = 1203;

        // Initialize matrices
        double[][] matrixA = generateRandomMatrix(rowsA, colsA, true);
        double[][] matrixB = generateRandomMatrix(rowsB, colsB, true);

        // Run the multiplication multiple times and measure execution time
        int runs = 10;
        long totalTime = 0;
        for (int i = 0; i < runs; i++) {
            long startTime = System.currentTimeMillis();
            
            multiplyMatrices(matrixA, matrixB);
            
            long endTime = System.currentTimeMillis();
            totalTime += endTime - startTime;
        }

        // Calculate and display average time
        double averageTime = totalTime / (double) runs;
        System.out.println("MatrixMultiplicationDouble_a average execution time: " + averageTime + " milliseconds");
    }

	// generateRandomMatrix method
    private static double[][] generateRandomMatrix(int rows, int cols, boolean isInteger) {
        double[][] matrix = new double[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = isInteger ? random.nextInt(10) : random.nextDouble() * 10.0; 
            }
        }
        return matrix;
    }

    // multiplyMatrices method
    private static double[][] multiplyMatrices(double[][] matrixA, double[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }
}
