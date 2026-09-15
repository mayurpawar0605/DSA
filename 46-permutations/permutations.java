class Solution {
    static void solve(int[] nums,boolean[] visited ,List<Integer> output ,List<List<Integer>> ans){
        int n = nums.length;
        if(output.size() == n){
            //we get valid permutations
            ans.add(new ArrayList<>(output));
            return;
        }

        //try every number of array on first position
        for(int i = 0; i < n; i++){
            if(visited[i] != true){
                visited[i] = true;
                output.add(nums[i]);

                solve(nums,visited,output,ans);

                //backtracking
                visited[i] = false;
                output.remove(output.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        solve(nums, visited, output, ans);

        return ans;
    }
}