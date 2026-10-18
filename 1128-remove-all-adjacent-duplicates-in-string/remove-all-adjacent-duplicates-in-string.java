class Solution {
    public String removeDuplicates(String s) {
        // Deque<Character> st = new ArrayDeque<>();

        int j = 1;
        while(j < s.length()){
            if (s.charAt(j) == s.charAt(j - 1)) {
                s = s.substring(0, j - 1) + s.substring(j + 1);

                if (j > 1) {
                    j--;
                }
            } else {
                j++;
            }
        }
        return s;
    }
}