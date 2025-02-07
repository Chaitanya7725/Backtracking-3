import java.util.ArrayList;
import java.util.List;

// TC: O(n!) as the space for queen placing reduces as the row proceeds.
// SC: O(n) Intermediate array is used to store the configuration string.

// Backtracking approach is used here to check for every configuration.
public class NQueen {
    static List<List<String>> result;
    static boolean[][] grid;
    static int length;

    public static void main(String[] args) {
        solveNQueens(4);
        System.out.println(result);

        solveNQueens(6);
        System.out.println(result);
    }

    public static List<List<String>> solveNQueens(int n) {
        if (n == 0)
            return new ArrayList<>();
        result = new ArrayList<>();
        length = n;
        grid = new boolean[n][n];
        backtrack(0, n);
        return result;
    }

    private static void backtrack(int row, int n) {
        // base
        if (row == n) {
            List<String> intermediate = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                intermediate.add(sb.toString());
            }
            result.add(intermediate);
            return;
        }
        // logic
        for (int i = 0; i < n; i++) {
            if (isSafe(row, i)) {
                grid[row][i] = true;
                backtrack(row + 1, n);
                grid[row][i] = false;
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int i = row; i >= 0; i--) {
            if (grid[i][col])
                return false;
        }
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (grid[i][j])
                return false;
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < length) {
            if (grid[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }

}