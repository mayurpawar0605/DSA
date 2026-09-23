class Solution {
    static void solve(String[] str, String digits,List<String> ans ,int index ,StringBuilder output){
        if(output.length() == digits.length()){
            ans.add(output.toString());
            return;
        }

        char ch = digits.charAt(index);
        int currIndex = ch - '0';

        for(int i = 0; i < str[currIndex].length(); i++){
            char k = str[currIndex].charAt(i);
            output.append(k);

            solve(str,digits,ans,index + 1,output);

            output.deleteCharAt(output.length() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        //string array of letter associated to index 
        String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        solve(str,digits,ans,0,output);
        return ans;
    }
}