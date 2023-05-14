import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] matrixSize = scanner.nextLine().split(" ");
        int row = Integer.parseInt(matrixSize[0]);
        int col = Integer.parseInt(matrixSize[1]);

        int [][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] m1 = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(m1[j]);

            }
        }

        String [] matrixSize2 = scanner.nextLine().split(" ");
        int row2 = Integer.parseInt(matrixSize2[0]);
        int col2 = Integer.parseInt(matrixSize2[1]);

        int [][] matrix2 = new int[row2][col2];

        for (int i = 0; i < row2; i++) {
            String[] m12 = scanner.nextLine().split(" ");
            for (int j = 0; j < col2; j++) {
                matrix2[i][j] = Integer.parseInt(m12[j]);

            }
        }
        if (EqualMatrix(matrix, matrix2)){
            System.out.println("equal");

        }else {
            System.out.println("not equal");
        }

    }
    public static boolean EqualMatrix(int[][] matrix, int[][] matrix2){
        if (matrix.length != matrix2.length){
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix2[i].length){
                return false;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
