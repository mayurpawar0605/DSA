class Solution {
    public String reverseWords(String s) {
        
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        int i = n-1;
        //remove trailing spaces at last
        while(s.charAt(i) == ' '){
            i--;
        }

        while(i >= 0){
            //now i is on lastChar of word
            
            int j = i;
            while(j >= 0 && s.charAt(j) != ' '){
                j--;
            }

            //between i and j there is word
            //add that word in ans 
            ans.append(s.substring(j+1,i+1));

            //remove trailing spaces at last
            while(j >= 0 && s.charAt(j) == ' '){
                j--;
            }

            if(j >= 0){
                ans.append(' ');
            }
            i = j;
        }
        return ans.toString();
    }
}