class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(sum - target) < Math.abs(closest - target)){
                    closest = sum;
                }

                if(sum < target){
                    j++;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }else if(sum > target){
                    k--;
                    while(k > j && nums[k] == nums[k + 1]){
                        k--;
                    }
                }else{
                    return sum;  // exact match
                }
            }
        }
        return closest;
    }
}