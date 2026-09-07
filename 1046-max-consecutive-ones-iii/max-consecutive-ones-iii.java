class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int noOfZeros = 0;
            for(int j = i; j < n ; j ++){
                if(nums[j] == 0){
                    noOfZeros ++;
                }
                if(noOfZeros <= k){
                    int length = j - i + 1;
                    maxLength = Math.max(maxLength , length);
                }else{
                    //noOfZeros excedding k
                    break;
                }
            }
        }
        return maxLength;
    }
}