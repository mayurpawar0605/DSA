class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;

        //jab tak j array ki lenght se chota hai
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                //ignore
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }

        return i + 1;
    }
}