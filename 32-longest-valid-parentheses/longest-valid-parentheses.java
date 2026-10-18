class Solution {
    public int longestValidParentheses(String s) {
        // Deque<Integer> st = new ArrayDeque<>();
        // st.push(-1);

        // int maxLen = 0;

        // for(int i = 0; i < s.length(); i++){
        //     if(s.charAt(i) == '('){
        //         st.push(i);
        //     }else{
        //         //closing bracket
        //         st.pop();
        //         if(st.isEmpty()){
        //             //invalid paranthesis -> reset kro
        //             //move to next -> set new Left boundry
        //             st.push(i);
        //         }else{
        //             //valid case -> opening bracket index available
        //             maxLen = Math.max(maxLen,i-st.peek());
        //         }
        //     }
        // }
        // return maxLen;


        int open = 0;
        int close = 0;
        int maxLen = 0;

        //left to right  travel
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open ++;
            }else{
                close ++;
            }

            if(close > open){
                //invalid -> reset
                open = 0;
                close = 0;
            }else if(open == close){
                // valid 
                maxLen = Math.max(maxLen,2*close);
            }
        }

        //right to left 
        open  = 0;
        close = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '('){
                open ++;
            }else{
                close ++;
            }

            if(close < open){
                //invalid -> reset
                open = 0;
                close = 0;
            }else if (open == close){
                // valid 
                maxLen = Math.max(maxLen,2*open);
            }
        }

        return maxLen;
    }
}