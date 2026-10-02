class Solution {
    static void solve(int open, int close,int n, List<String> ans,StringBuilder output){
        //base case
        if(close >= n){
            if(open == 0){
                ans.add(output.toString());
            }
            return;
        }
        if(open > n){
            return;
        }


        //we have to make two calls
        //open 
        output.append('(');
        solve(open + 1, close,n,ans,output);
        output.deleteCharAt(output.length() - 1);

        //close
        if(open > 0){
            output.append(')');
            solve(open - 1, close + 1,n,ans,output);
            output.deleteCharAt(output.length() - 1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        int open = 0;
        int close = 0;
        solve(open,close,n,ans,output);
        return ans;
    }
}