class Solution {
    static void reverse(int[][] grid, int i , int j){
        int row = grid.length;
        int col = grid[0].length;

        while(i < j){
            int temp = grid[i / col][i % col];
            grid[i/col][i%col] = grid[j/col][j%col];
            grid[j/col][j%col] = temp;
            i++;
            j--;
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int n =  row*col;

        k = k % n;

        reverse(grid, 0, n - 1);
        reverse(grid, 0, k - 1);
        reverse(grid, k, n - 1);

        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < row; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j  =0; j < col; j ++){
                temp.add(grid[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}