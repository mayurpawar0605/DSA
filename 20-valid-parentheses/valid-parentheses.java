class Solution {
    public boolean isValid(String s) {
        // if(s.length() % 2 != 0){
        //     return false;
        // }
        // Stack<Character> st = new Stack<>();

        // for(int i=0; i < s.length();i++){
        //     char ch = s.charAt(i);
            
        //     //if it is operening character 
        //     if(ch == '(' || ch == '{' || ch == '['){
        //         st.push(ch);
        //     }
        //     else{
        //         //get a closing character 
        //         //check if stack is empty
        //         if(st.isEmpty()){
        //             return false;
        //         }
        //         char k = st.peek();
        //         if(k == '(' && ch == ')' ||
        //            k == '{' && ch == '}' ||
        //            k == '[' && ch == ']'  ){
        //             st.pop();
        //         }
        //         else{
        //             return false;
        //         }
        //     }
        // }
        // return st.isEmpty();

        Deque<Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            //if this is oper bracket
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                //if it is closing bracket
                //check first stack is empty or not -> if empty return false
                if(st.isEmpty()){
                    return false;
                }
                //no match case 
                if( ch == ')' && st.peek() != '(' || 
                    ch == '}' && st.peek() != '{' ||
                    ch == ']' && st.peek() != '['){

                    return false;
                }else{
                    //match case
                    st.pop();
                    }
            }

        }
        return st.isEmpty();

    }
}