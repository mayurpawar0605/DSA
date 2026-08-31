class Solution {
    public int findMin(int[] nums) {
        // int n = nums.length;
        // int min = Integer.MAX_VALUE;
        // for(int num : nums){
        //     min = Math.min(min,num);
        // }
        // return min;
        int n = nums.length;
        int s = 0;
        int e = n-1;
        int minIdx = 0;

        if(nums[0] < nums[n-1]){
            return nums[0];
        }

        while(s <= e){
            int mid = s + (e-s) / 2;

            if(nums[mid] == nums[e]){
                e--;
                if(nums[mid] <= nums[minIdx]){
                    minIdx = mid;
                }
                continue;
            }
            if(nums[mid] < nums[minIdx]){
                minIdx = mid;
            }

            if(nums[mid] < nums[e]){
                e = mid -1;
            }
            else{
                s = mid + 1;
            }
        }
        
        return nums[minIdx];
    }
}