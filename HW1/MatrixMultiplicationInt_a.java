import java.util.Random;

public class MatrixMultiplicationInt_a {
	// main method
	public static void main(String[] args) {
        // Define matrix sizes
        int rowsA = 1201, colsA = 1202; 
        int rowsB = colsA, colsB = 1203;

        // Initialize matrices
        int[][] matrixA = generateRandomMatrix(rowsA, colsA, true);
        int[][] matrixB = generateRandomMatrix(rowsB, colsB, true);

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
        System.out.println("MatrixMultiplicationInt_a average execution time: " + averageTime + " milliseconds");
    }

    // Generates Random Matrix
    private static int[][] generateRandomMatrix(int rows, int cols, boolean isInteger) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = isInteger ? random.nextInt(10) : 0; 
            }
        }
        return matrix;
    }

    // Multiply Matrices
    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

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
