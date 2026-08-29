class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1 || n == 4){
            return true;
        }
        for(int i = 4; i <= n/4; i *= 4){
            int currnum = i * 4;
            if(currnum == n){
                return true;
            }
        }
        return false;

        
    }
}