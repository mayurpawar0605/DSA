class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int maxCount = 0;

        //handling case where only single element present in array itha 1
        if(n == 1 && nums[0] == 1){
            return 1;
        }

        int i = 0;
        int j = 0;
        while(j < n){
            if(nums[i] == 0){
                i++;
                j++;
            }
            else if(nums[i]==1 && nums[j]==1){
                count = j - i + 1;
                maxCount = Math.max(count,maxCount);
                j++;
            }
            else if(nums[j] == 0){
                i = j + 1;
                j = i + 1;
            }
        }
        return maxCount;
    }
}