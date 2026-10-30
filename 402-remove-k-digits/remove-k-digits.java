class Solution {
    public String removeKdigits(String num, int k) {
        
        int n = num.length();

        if (k == 0){
            return num;
        }
        if(k == n){
            return "0";
        }

        Deque<Character> st = new ArrayDeque<>();

        int i =0;

        for(char ch : num.toCharArray()){
            
            //monotic stack pattern
            while(!st.isEmpty() && k > 0 &&  st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        //if K > 0 - removals are pending
        while(k > 0){
            st.pop();
            k--;
        }

        //build your ans ,reverse it ,remove leading 0`s
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        ans.reverse();

        // handling leading 0`s
        int index = 0;
        while(index < ans.length() && ans.charAt(index) == '0'){
            index ++;
        }

        String result = ans.substring(index);
        if(result.length() == 0){
            return "0";
        }else{
            return result;
        }
    }
}