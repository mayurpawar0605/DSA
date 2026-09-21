class Solution {
    static void solve(int curr ,int n, int k, List<List<Integer>> ans, List<Integer> output){
        //base case
        if(output.size() == k){
            ans.add(new ArrayList<>(output));
            return;
        }
        if(curr > n){
            return;
        }

        //solve using include exclude pattern
        //include
        output.add(curr);
        solve(curr+1,n,k,ans,output);

        //exclude
        //backtrack
        output.remove(output.size() - 1);
        solve(curr+1,n,k,ans,output);

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(1,n,k,ans,output);
        return ans;
    }
}