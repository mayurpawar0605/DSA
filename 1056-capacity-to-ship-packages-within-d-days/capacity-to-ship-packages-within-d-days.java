class Solution {
    static boolean solve(int[] weights, int days,int mid ){
        int currDays = 1;
        int currWeight  = 0;
        for(int i = 0; i < weights.length; i++){
            if(currWeight + weights[i] <= mid){
                currWeight += weights[i];
            }else{
                currDays ++;
                if(weights[i] > mid || currDays > days){
                    return false;
                }
                currWeight = weights[i];
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        //to find ending limit -> sum
        int e = 0;
        for(int i = 0; i < n; i++){
            e += weights[i];
        }
        int s = 1;
        int ans = 0;

        while(s <= e){
            int mid = (s + e) / 2;
            if(solve(weights,days,mid)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}