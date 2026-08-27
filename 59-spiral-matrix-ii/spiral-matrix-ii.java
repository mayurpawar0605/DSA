class Solution {
    public int[][] generateMatrix(int n) {
        int startCol = 0;
        int endCol = n-1;
        int startRow = 0;
        int endRow = n-1;

        int[][] ans = new int [n][n];

        int m = 1;

        while(startCol <= endCol && startRow <= endRow){
            //start row -> startCol to endCol
            for(int i = startCol; i <= endCol; i++){
                ans[startRow][i] = m;
                m++;
            }
            startRow ++;

            //ending col -> startRow to endRow
            for(int i = startRow; i <= endRow; i++){
                ans[i][endCol] = m;
                m++;
            }
            endCol --;

            //endRow -> endCol to startCol
            for(int i = endCol; i >= startCol; i--){
                ans[endRow][i] = m;
                m++;
            }
            endRow --;

            //startCol -> endRow to startRow 
            for(int i = endRow; i >= startRow; i--){
                ans[i][startCol] = m;
                m++;
            }
            startCol ++;
        }
        return ans;
    }
}