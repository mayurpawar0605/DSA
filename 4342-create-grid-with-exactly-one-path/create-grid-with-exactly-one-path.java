class Solution {
    public String[] createGrid(int m, int n) {
        
        char[][] grid = new char[m][n];

        int i = 0;
        int j  =0;
        grid[i][j] = '.';

        while(i < m && j < n){
            
            if(j + 1 < n){
                j = j + 1;
                grid[i][j] = '.';
            }

            if(i + 1 < m){
                i = i + 1;
                grid[i][j] = '.';
            }

            if(i == m-1 && j == n-1){
                break;
            }
        }
        
        String[] ans = new String[m];

        for(int p = 0; p < m; p++){
            StringBuilder temp = new StringBuilder();
            for(int q = 0 ; q < n ; q++){
                if(grid[p][q] != '.'){
                    temp.append('#');
                }else{
                    temp.append('.');
                }
            }
            ans[p] = temp.toString();
        }

        return ans;

    }
}