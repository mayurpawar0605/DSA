class Solution {
    static boolean solve(char[][] board, String word, boolean[][] visited, int index, int i, int j) {
        //base cases
        //bopundy check
        int n = board.length;
        int m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        //character check
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        //already visited
        if (visited[i][j] == true) {
            return false;
        }
        //valid case -> match found
        if (index >= word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        //now we have to solve recursion 
        //we have 4 directions
        //up
        if (solve(board, word, visited, index + 1, i - 1, j)) {
            return true;
        }
        //down
        if (solve(board, word, visited, index + 1, i + 1, j)) {
            return true;
        }
        //rigth
        if (solve(board, word, visited, index + 1, i, j + 1)) {
            return true;
        }
        //left
        if (solve(board, word, visited, index + 1, i, j - 1)) {
            return true;
        }

        visited[i][j] = false;

        return false;

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (solve(board, word, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}