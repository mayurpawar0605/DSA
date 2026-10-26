class Solution {
    static long solve(int[][] grid , int i, int j, long sum){

        int m  = grid.length;
        int n = grid[0].length;

        //base case
        if(i >= m || i < 0){
            return sum;
        }
        if(j >= n || j < 0){
            return sum;
        }
        if(grid[i][j] == 0) {
            return sum;
        }

        sum += grid[i][j];
        grid[i][j] = 0;

        //cases
        sum = solve(grid, i + 1,j, sum);
        sum = solve(grid , i ,j + 1, sum);
        sum = solve(grid, i - 1,j, sum);
        sum = solve(grid , i ,j - 1, sum);

        return sum;
    }


    public int countIslands(int[][] grid, int k) {
        int m  = grid.length;
        int n = grid[0].length;

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0 ){
                    long sum = solve(grid, i, j, 0);
                    if(sum % k == 0){
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}