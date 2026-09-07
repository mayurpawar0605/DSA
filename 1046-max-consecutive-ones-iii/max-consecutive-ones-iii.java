class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int zeros = 0;

        //optinal approach

        while(r < n){
            if(nums[r] == 0){
                zeros ++;
            }
            if(zeros > k){
                if(nums[l] == 0){
                    zeros --;
                }
                l++;
            }
            if(zeros <= k){
                //valid condition find length
                int length = r - l + 1;
                maxLength = Math.max(maxLength , length);
            }
            r++;
        }

        //brute force

        // for(int i = 0; i < n; i++){
        //     int noOfZeros = 0;
        //     for(int j = i; j < n ; j ++){
        //         if(nums[j] == 0){
        //             noOfZeros ++;
        //         }
        //         if(noOfZeros <= k){
        //             int length = j - i + 1;
        //             maxLength = Math.max(maxLength , length);
        //         }else{
        //             //noOfZeros excedding k
        //             break;
        //         }
        //     }
        // }
        return maxLength;
    }
}