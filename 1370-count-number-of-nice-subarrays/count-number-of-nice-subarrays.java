class Solution {
    static int solve(int[] nums, int k){
        if(k < 0){
            return 0;
        }
        int l =0;
        int r = 0;
        int sum = 0;
        int count = 0;

        while(r < nums.length){
            sum += nums[r] % 2;

            while(l < nums.length && sum > k){
                sum -= nums[l] % 2;
                l++;
            }
            //sum <= k
            count += r - l + 1;
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k) - solve(nums,k -1);
    }
}