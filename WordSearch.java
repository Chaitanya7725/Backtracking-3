// TC: O((m * n )* 3 ^ l ) where l is the length of the word
// SC: O(l) where l is the length of the word
public class WordSearch {
    public static void main(String[] args) {
        System.out.println(
                exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } },
                        "ABCCED"));
    }

    static int m, n;
    static int dirs[][];

    private static boolean exist(char[][] input, String word) {
        m = input.length;
        n = input[0].length;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // U D L R
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(input, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] input, String word, int row, int col, int index) {
        // base
        if (row < 0 || row >= m || col < 0 || col >= n)
            return false;
        if (index == word.length())
            return true;
        // logic
        if (input[row][col] == word.charAt(index)) {
            char temp = word.charAt(index);
            input[row][col] = '#';
            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (backtrack(input, word, nr, nc, index + 1))
                    return true;
            }
            input[row][col] = temp;
        }
        return false;
    }
}
