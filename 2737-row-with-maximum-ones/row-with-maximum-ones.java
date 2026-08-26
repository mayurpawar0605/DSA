class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int totalRow = mat.length;
        int totalCols = mat[0].length;

        int maxOneCount = 0;
        int maxOneCountRow = 0; 
        

        for(int i = 0; i < totalRow; i++){
            int count = 0;

            for(int j = 0; j < totalCols; j++){
                if(mat[i][j] == 1){
                    count ++;
                }
            }
            if(count > maxOneCount){
                maxOneCount = count;
                maxOneCountRow = i;
            }
        }

        int arr[] = {maxOneCountRow,maxOneCount};
        return arr;
    }
}