class Solution {
    static boolean isValidAns(int[] nums, int threshold, int divisor){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count += Math.ceil((double) nums[i] / divisor);
            if(count > threshold){
                return false;
            }
        }
        
        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(nums[i],max);
            // min = Math.min(nums[i],min);
        }
        int s = 1;
        int e = max;
        int ans = -1;

        while(s <= e){
            int mid = s + (e - s) / 2;
            if(isValidAns(nums, threshold, mid)){
                e = mid - 1;
                ans = mid;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}