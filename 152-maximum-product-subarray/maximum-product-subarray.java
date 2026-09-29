class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int prefix = 1;
        int suffix = 1;
        int max = nums[0];

        for(int i =0; i < n; i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            //forward multiplication 
            prefix *= nums[i];

            //backward multiplication
            suffix *= nums[n-i-1];

            //find max of them
            int k = Math.max(prefix,suffix);
            max = Math.max(max,k);
        }
        return max;
    }
}