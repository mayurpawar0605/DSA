class Solution {
   
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int maxLen = 0;

        for(int i = 0; i < n ; i ++){
            int[] arr = new int [256];
            for(int j = i ; j < n; j ++){
                char ch = s.charAt(j);
                int index = ch;
                if(arr[index] == 1){
                    break;
                }
                int length = j - i + 1;
                maxLen = Math.max(length,maxLen);
                arr[index]++;
            }
        }
        return maxLen;
    }
}