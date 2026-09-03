class Solution {
    public static int getFirstIdx(int[] nums, int target , int s, int e){
        int ans = -1;
        while(s <= e){
            int mid = (s + e) / 2;
            if(target <= nums[mid]){
                if(nums[mid] == target){
                    ans = mid;
                }
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
    public static int getLastIdx(int[] nums, int target , int s, int e){
        int ans = -1;
        while(s <= e){
            int mid = (s + e) / 2;
            if(target >= nums[mid]){
                if (nums[mid] == target) {
                    ans = mid;
                }
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        int e = n-1;

        int firstIdx = getFirstIdx(nums, target, s, e);
        int LastIdx = getLastIdx(nums, target, s, e);

        int[] ans = {firstIdx, LastIdx};
        return ans;
    }
}