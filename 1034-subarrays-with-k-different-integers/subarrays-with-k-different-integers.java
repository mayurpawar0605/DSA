class Solution {
    //solve for 
    //number of subarray whose integers <=k and <=k-1
    
    static int solve(int[] nums,int k){
        int l = 0;
        int r = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(r < nums.length){
            map.put(nums[r] ,map.getOrDefault(nums[r],0) + 1);

            while(map.size() > k){
                map.replace(nums[l],map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            //count + length of current subarray
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return solve(nums,k) - solve(nums,k-1);







        // int n = nums.length;
        // int count = 0;
        // for(int i =0; i < n;i++){
        //     HashMap<Integer,Integer> map = new HashMap<>();
        //     for(int j = i; j < n;j++){
        //         map.put(nums[j] ,map.getOrDefault(nums[j],0) + 1);
        //             if(map.size()==k){
        //                 count ++;
        //             }
        //             if(map.size() > k){
        //                 break;
        //             }
        //     }
        // }
        // return count;

    }
}