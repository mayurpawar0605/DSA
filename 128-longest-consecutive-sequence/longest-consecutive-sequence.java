class Solution {
    public int longestConsecutive(int[] nums) {
        /*

        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);

        int count = 1;
        int max = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]){
                continue;
            }
            if(nums[i] - 1 == nums[i - 1]){
                count ++;
                max = Math.max(count, max);
            }else{
                count = 1;
            } 
        }
        return max;
        */

        int n = nums.length;
        int max = 0;
        int count = 1;
        Set<Integer> set = new HashSet<>();
        //O(n)
        for(int num : nums){
            set.add(num);
        }


        // O(2n)
        for(int num : set){
            if(!set.contains(num-1)){
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                max = Math.max(max,count);
                count = 1;
            }
        }
        return max;
    }
}