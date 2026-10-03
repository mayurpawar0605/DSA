class Solution {
    public boolean isPalindrome(String string) {
        String str = string.trim();
        String s = str.toLowerCase();
        int j = s.length() - 1;
        int i = 0;
        while(i < j){
             while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}