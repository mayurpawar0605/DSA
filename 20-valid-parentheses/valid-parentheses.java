class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i < s.length();i++){
            char ch = s.charAt(i);
            //if it is operening character 
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                //get a closing character 
                //check if stack is empty
                if(st.isEmpty()){
                    return false;
                }
                char k = st.peek();
                if(k == '(' && ch == ')' ||
                   k == '{' && ch == '}' ||
                   k == '[' && ch == ']'  ){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}