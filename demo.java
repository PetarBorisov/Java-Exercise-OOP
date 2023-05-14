import java.util.Arrays;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] firstRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] =firstRow[col];
            }
        }
        for (int row = matrix.length - 2; row >= 0; row--) {
            for (int col  = matrix.length - 2; col >= 0; col--) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        }

    }

