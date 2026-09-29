class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> list = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;
        int endRow = m - 1;
        int endCol = n - 1;

        while(startRow <= endRow && startCol <= endCol){
            for(int i = startCol; i <= endCol ; i++){
                list.add(matrix[startRow][i]);
            }

            startRow++;
            if(startRow > endRow) break;

            for(int i = startRow; i <= endRow ;i++){
                list.add(matrix[i][endCol]);
            }
            endCol--;
            if(startCol > endCol) break;

            for(int i = endCol; i >= startCol ;i--){
                list.add(matrix[endRow][i]);
            }
            endRow--;
            if(startRow > endRow) break;

            for(int i = endRow; i >= startRow ;i--){
                list.add(matrix[i][startCol]);
            }
            startCol++;
            if(startCol > endCol) break;
        }
        return list;
    }
}