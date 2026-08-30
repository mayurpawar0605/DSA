class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min,num);
        }
        return min;
        // int s = 0;
        // int e = n-1;
        // int pivote = -1;

        // if(n==1){
        //     return nums[0];
        // }
        // if(nums[0] <= nums[n-1]){
        //     return nums[0];
        // }

        // while(s <= e){
        //     int mid = s + (e-s) / 2;
        //     if(nums[mid] <= nums[n-1]){
        //         e = mid -1;
        //     }else{
        //         pivote = mid;
        //         s = mid + 1;
        //     }
        // }
        // int min = nums[pivote+1];
        // return min;
    }
}