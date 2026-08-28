class Solution {
    public int lengthOfLastWord(String s) {
        //take two pointer and place them at n-1 index last of string
        int i = s.length()-1;
        int j = s.length()-1;

        while(i >= 0){
            //i wnat to find char not spaces
            //if i get space -> -- both pointers
            if(s.charAt(i) == ' '){
                i--;
                j--;
            }else{
                i--;
                if(i < 0){
                    return j - i;
                }
                if(s.charAt(i) == ' '){
                    return j-i;
                }
            }
        }
        return 0;
    }
}