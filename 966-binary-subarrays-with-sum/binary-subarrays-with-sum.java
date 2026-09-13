class Solution {
    static int numberOfSubArraysWithSumLessThanEqualToGoal(int[] nums,int goal){
        //if goal = 0;
        //then gaol -1 = -1
        //ans = 0 - (-1) = 0  + 1 wrong 
        if(goal < 0){
            return 0;
        }

        int r = 0;
        int l = 0;
        int sum = 0;
        int count = 0;
        int n = nums.length;

        while(r < n){
            sum += nums[r];

            while(l < n && sum > goal){
                sum = sum - nums[l];
                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;

    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        //it can be solved by prefix sum 
        //but this is most optonam approach 
        //sum == goal  =  sum <= gaol  - sum <= gaol - 1;
        return 
        numberOfSubArraysWithSumLessThanEqualToGoal(nums,goal) - numberOfSubArraysWithSumLessThanEqualToGoal(nums,goal - 1);
    }   
}