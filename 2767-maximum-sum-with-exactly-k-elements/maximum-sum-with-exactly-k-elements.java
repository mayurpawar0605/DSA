class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxIdx = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[maxIdx]){
                maxIdx = i;
            }
        }
        int sum = 0;
        for(int i = 1; i <= k; i ++){
            sum += nums[maxIdx];
            nums[maxIdx] += 1;
        }
        return sum;
    }
}