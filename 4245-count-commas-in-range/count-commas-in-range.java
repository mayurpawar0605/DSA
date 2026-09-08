class Solution {
    public int countCommas(int n) {
        if(n > 999){
            return n- 999;
        }else{
            return 0;
        }
        // String s = String.valueOf(n);
        // int m = s.length() - 1;
        // if(m <= 4){
        //     return 0;
        // }else{
        //     return m - 1;
        // }
    }
}