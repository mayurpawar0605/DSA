class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);

        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                //closing bracket
                st.pop();
                if(st.isEmpty()){
                    //invalid paranthesis
                    //move to next -> set new Left boundry
                    st.push(i);
                }else{
                    //valid case -> opening bracket index available
                    maxLen = Math.max(maxLen,i-st.peek());
                }
            }
        }
        return maxLen;
    }
}