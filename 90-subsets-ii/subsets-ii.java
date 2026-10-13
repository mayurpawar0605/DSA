class Solution {
    static void solve(int[] nums , int index, List<Integer> output , List<List<Integer>> ans ){
        //base case
        if(index >= nums.length){
            //subsequence is ready in output
            //strore that in ans 
            //we have to addd copy of output in ans 
            //we can`t add same output referance every time
            ans.add(new ArrayList<>(output));
            return;
        }
        int currValue = nums[index];

        //include
        output.add(currValue);
        solve(nums, index + 1, output, ans);

        //BACKTRACKING -> 
        //we need to remove currentValue form output for exclude case 
        output.remove(output.size() - 1);

        //before excluding we need to remove -> duplucate value that is already excluded
        //that gives all unique subsets
        //it is only apply when the array is soretd 
        //we need to sort array 
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index ++;
        }
        //exclude call
        solve(nums, index + 1, output , ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        solve(nums ,index, output, ans);
        return ans;
    }
}