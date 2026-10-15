class Solution {
    public int minAddToMakeValid(String s) {
        // int count = 0;
        // Deque<Character> st = new ArrayDeque<>();

        // for(char ch: s.toCharArray()){
        //     if(ch == '('){
        //         st.push(ch);
        //     }else{
        //         if(st.isEmpty()){
        //             count++;
        //         }else{
        //             st.pop();
        //         }
        //     }
        // }

        // return count + st.size();

        int open = 0;
        int close = 0;

        for(char ch: s.toCharArray()){
            if(ch == '('){
                open++;
            }else{
                if(open == 0){
                    close++;
                }else{
                    open--;
                }
            }
        }
        
        return open + close;
    }
}