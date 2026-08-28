class Solution {
    public int lengthOfLastWord(String s) {
        //take two pointer and place them at n-1 index last of string
        int i = s.length()-1;
        int j = s.length()-1;

        while(i >= 0){
            //we wnat to find char not spaces
            //if i get space -> -- both pointers
            if(s.charAt(i) == ' '){
                i--;
                j--;
            }else{
                //j pointer on a char 
                //i index will find space or go to less than 0
                i--;
                if(i < 0){
                    //if i smaller than 0 we traverse on full string 
                    //return current length
                    return j - i;
                }
                if(s.charAt(i) == ' '){
                    //we again get empty space we find a word 
                    //return length of that word
                    return j-i;
                }
            }
        }
        return 0;
    }
}