class Solution {
    static boolean isSafeToPlace(int rowIndex, int colIndex,char[][] board,int n){
        //check for LEFT
        int row = rowIndex;
        int col = colIndex;

        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        //check for LEFT UPPER DIAGONAL
        row = rowIndex;
        col = colIndex;

        while(col >= 0 && row >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        //check for LEFT LOWER DIAGONAL
        row = rowIndex;
        col = colIndex;

        while(col >= 0 && row < n){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        //if all conditions are satisfied 
        //we able to place queen 
        return true;
    }

    static void solve(char[][] board, int n ,int colIndex,List<List<String>> ans){
        //base case 
        //colindex == n -> we get our ans 
        //Oueens does not attack each other -> placed safely
        if(colIndex == n){
            //we have create string of each row 
            //and add it to new list & add this list to ans
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        //Logic - > Recursion
        ////for ecah col -> place queen at every row & handle to recursion
        for(int rowIndex = 0; rowIndex < n; rowIndex ++){
            //place if safe
            if(isSafeToPlace(rowIndex,colIndex,board,n)){
                board[rowIndex][colIndex] = 'Q';
                //check for next col
                solve(board,n,colIndex + 1,ans);

                //backtrack
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int colIndex = 0;
        List<List<String>> ans = new ArrayList<>();

        solve(board, n, colIndex, ans);

        return ans;
    }
}