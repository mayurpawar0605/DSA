class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // int n=nums.length;
        // Set<List<Integer>> ans = new HashSet<>();

        // for(int i = 0; i < n; i++){
        //     Set<Integer> set = new HashSet<>();
        //     for(int j = i + 1; j < n; j ++){
        //         int k = -(nums[i] + nums[j]);   
        //         if(set.contains(k)){
        //             List<Integer> temp = new ArrayList<>();
        //             temp.add(nums[i]);
        //             temp.add(nums[j]);
        //             temp.add(k);

        //             Collections.sort(temp);
        //             ans.add(temp);
        //         }
        //         set.add(nums[j]);
        //     }
        // }
        // return new ArrayList<>(ans);

        Arrays.sort(nums);        
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }else if (sum < 0){
                    j++;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    Collections.sort(temp);
                    list.add(temp);

                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                }
            }
        }
        return list;

        
    }
}