class Solution {
    public static int binarySearch(int s, int e, int[] nums, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            } 
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        if(nums[0] <= nums[n/2] && nums[n/2] <= nums[n-1]){
            return binarySearch(0 , n-1 , nums, target);
        }
        int pivote = -1;

        //finding pivote index to apply binary search
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > nums[n - 1]) {
                pivote = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        if (target >= nums[0] && target <= nums[pivote]) {
            return binarySearch(0, pivote, nums, target);
        } else if (target >= nums[pivote + 1] && target <= nums[n - 1]) {
            return binarySearch(pivote + 1, n - 1, nums, target);
        }
        return -1;
    }
}