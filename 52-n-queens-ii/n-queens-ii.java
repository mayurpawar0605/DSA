class Solution {
    static boolean isSafeToPlace(int[][] board, int n , int row, int col){
        //check for left side of current row
        int colIndex = col;
        for(int i = colIndex ; i >= 0; i--){
            if(board[row][i] == 1){
                return false;
            }
        }

        //check for upper diagonal
        int rowIndex = row;
        colIndex = col;

        while(rowIndex >= 0 && colIndex >= 0){
            if(board[rowIndex][colIndex] == 1){
                return false;
            }
            rowIndex--;
            colIndex--;
        }

        //check for lower diagonal
        rowIndex = row;
        colIndex = col;

        while(rowIndex < n && colIndex >= 0){
            if(board[rowIndex][colIndex] == 1){
                return false;
            }
            rowIndex++;
            colIndex--;
        }
        //safe to place
        return true;
    }

    static int solve(int[][] board, int n , int col){
        if(col >= n){
            return 1;
        }

        int ans = 0;

        for(int row = 0; row < n; row++){
            if(isSafeToPlace(board,n,row,col)){
                //place Queen
                board[row][col] = 1;

                ans += solve(board,n,col + 1);

                //backtracking
                board[row][col] = 0;
            }
        }
        return ans;

    }
    public int totalNQueens(int n) {
        int[][] board =  new int[n][n];
        return solve(board , n , 0);
    }
}