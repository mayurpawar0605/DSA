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

        // if(n == 1 || n == 4){
        //     return true;
        // }

        // int s = 1;
        // int e = n;

        // while(s <= e){
        //     int mid = s+(e-s)/2;
        //     if(mid * 4 == n){
        //         return true;
        //     }else if (mid * 4 > n){
        //         e = mid - 1;
        //     }else{
        //         s = mid + 1;
        //     }
        // }
        // return false;
    }
}