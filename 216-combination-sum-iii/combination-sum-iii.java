class Solution {
    static void solve(int num, int target, List<Integer> output, List<List<Integer>> ans, int k){
        
        if(target == 0 && output.size() == k){
            ans.add(new ArrayList<>(output));
            return;
        }
        if(target < 0){
            return;
        }
        
        if(num > 9){
            return;
        }
        if(output.size() > k){
            return;
        }
        //include 
        output.add(num);
        solve(num + 1,target - num,output , ans,k);

        //exclude
        output.remove(output.size() - 1);
        solve(num+1, target, output, ans, k);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int num = 1;
        int target = n;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(num, target, output, ans, k);
        return ans;
    }
}