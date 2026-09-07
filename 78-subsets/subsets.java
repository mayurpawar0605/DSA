class Solution {
    static void solve(int[] nums , int index, List<Integer> output , List<List<Integer>> ans ){
        //base case
        if(index >= nums.length){
            //subsequence is ready in output
            //strore that in ans 
            ans.add(new ArrayList<>(output));
            return;
        }
        int currValue = nums[index];

        //include
        output.add(currValue);
        solve(nums, index + 1, output, ans);

        //backtracking -> we need to remove currentValue form output for exclude case 
        output.remove(output.size() - 1);
        //exclude call
        solve(nums, index + 1, output , ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        solve(nums ,index, output, ans);
        return ans;
    }
}