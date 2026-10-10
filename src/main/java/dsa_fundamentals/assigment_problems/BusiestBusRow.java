
package dsa_fundamentals.assigment_problems;

import java.util.Scanner;

public class BusiestBusRow {

    static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;

            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }

            if (total > maxTotal) {
                maxTotal = total;
                bestRow = i;
            }
        }

        return new int[]{bestRow, maxTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();

        int[][] grid = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] result = busiestRow(grid);

        System.out.println(
            "Row " + result[0] + ", Total " + result[1]
        );

        sc.close();
    }
}
