class Solution {
    static long solve(int[][] grid,boolean visited[][] , int i, int j, long sum){

        int m  = grid.length;
        int n = grid[0].length;

        //base case
        if(i >= m || i < 0){
            return sum;
        }
        if(j >= n || j < 0){
            return sum;
        }
        if(visited[i][j] == true){
            return sum;
        }
        if(grid[i][j] == 0) {
            return sum;
        }

        visited[i][j] = true;
        sum += grid[i][j];

        //cases
        sum = solve(grid, visited , i + 1,j, sum);
        sum = solve(grid, visited , i ,j + 1, sum);
        sum = solve(grid, visited , i - 1,j, sum);
        sum = solve(grid, visited , i ,j - 1, sum);

        return sum;
    }


    public int countIslands(int[][] grid, int k) {
        int m  = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && grid[i][j] != 0){
                    long sum = solve(grid, visited, i, j, 0);
                    if(sum % k == 0){
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}