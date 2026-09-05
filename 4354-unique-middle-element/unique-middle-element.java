class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        int mid = n / 2;

        if(map.get(nums[mid]) == 1){
            return true;
        }

        // if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
        //     return true;
        // }

        return false;

    }
}