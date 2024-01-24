import java.util.Scanner;

public class MatrixAddition {

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        // Check for compatible dimensions
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        // Create a result matrix with the same dimensions
        int[][] result = new int[matrix1.length][matrix1[0].length];

        // Add corresponding elements of each matrix
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for matrix 1: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix 1: ");
        int cols1 = scanner.nextInt();
        System.out.print("Enter the number of rows for matrix 2: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix 2: ");
        int cols2 = scanner.nextInt();

        // Create matrices
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];

        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Perform addition and store the result
        int[][] sumMatrix = addMatrices(matrix1, matrix2);

        // Print the result matrix
        System.out.println("Sum of matrices:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
