class Solution {
    static int kadensMax(int [] nums){
        int sum = nums[0];
        int maxSum = sum;

        for(int i =1 ; i < nums.length; i++){
            sum = Math.max(nums[i],sum + nums[i]);
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
    static int kadensMin(int [] nums){
        int sum = nums[0];
        int minSum = sum;

        for(int i =1 ; i < nums.length; i++){
            sum = Math.min(nums[i],sum + nums[i]);
            minSum = Math.min(sum,minSum);
        }
        return minSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
    
        //find sum
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        //find MaxSum
        int maxSum = kadensMax(nums);

        //find minSum 
        int minSum = kadensMin(nums);

        //find circular maxSum
        int circularMax = sum - minSum;

        if(maxSum > 0){
            return Math.max(maxSum,circularMax);
        }

        return maxSum;

    }
}