import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        IntStream.range(0, rows).forEach(row -> {
            int[] matrixRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = matrixRow;
        });

        {
            int col = cols - 1;
            while (col >= 0) {
                  int printRow = rows;
                int printCol = col;
                while (printCol <= cols - 1  && printRow > 0) {

                    if (printRow > 0) {
                        System.out.print(matrix[printRow - 1 ][printCol] + " ");
                        printRow--;
                    }
                    printCol++;
                }
                System.out.println();
                col--;
            }
        }


        if(rows >= 2) {
            int row = rows - 2;
            while (row >= 0) {
                int printRow = row;
                int col = 0;
                while (col <= row && col < cols) {
                    System.out.print(matrix[printRow][col] + " ");
                    printRow--;
                    col++;
                }
                System.out.println();
                row--;
            }
        }
    }
}







