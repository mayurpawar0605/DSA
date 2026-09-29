class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int prefix = 1;
        int suffix = 1;
        int max = 0;
        for(int i =0; i < n; i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[n-i-1];

            int k = Math.max(prefix,suffix);
            max = Math.max(max,k);
        }
        return max;
    }
}