class Solution {
    static void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;
        if(k == 0){
            return;
        }

        reverse(nums,0 , n-1);
        reverse(nums ,0, k - 1);
        reverse(nums, k , n -1);
    }
}











        // int rotation =k % n;

        // for (int l = 1; l <= rotation; l++) {

        //     int last = nums[n - 1];

        //     for (int i = n - 1; i >= 1; i--) {
        //         nums[i] = nums[i - 1];
        //     }

        //     nums[0] = last;
        // }