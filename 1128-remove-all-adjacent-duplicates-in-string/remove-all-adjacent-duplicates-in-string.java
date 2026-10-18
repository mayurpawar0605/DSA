class Solution {
    public String removeDuplicates(String s) {
        

        
        //Brute force -> O(n*2)

        // int j = 1;
        // while(j < s.length()){
        //     if (s.charAt(j) == s.charAt(j - 1)) {
        //         s = s.substring(0, j - 1) + s.substring(j + 1);

        //         if (j > 1) {
        //             j--;
        //         }
        //     } else {
        //         j++;
        //     }
        // }
        // return s;





        Deque<Character> st = new ArrayDeque<>();
        for(char  ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}