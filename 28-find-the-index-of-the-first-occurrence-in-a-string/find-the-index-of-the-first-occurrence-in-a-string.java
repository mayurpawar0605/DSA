class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int s = needle.length();

        int i = 0;
        int j = s-1;

        while(j < n){
            String subStr = haystack.substring(i,j+1);
            if(subStr.equals(needle)){
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }
}