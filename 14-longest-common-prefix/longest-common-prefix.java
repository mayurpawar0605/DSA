class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int n = strs.length;
        int i = 0;

        while(i < strs[0].length()){
            char ch = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return ans.toString();
                }
            }
            ans.append(ch);
            i++;
        }
        return ans.toString();
    }
}