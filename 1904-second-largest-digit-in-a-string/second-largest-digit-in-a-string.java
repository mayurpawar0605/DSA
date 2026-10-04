class Solution {
    public int secondHighest(String s) {
        int largest = -1;
        int secondLargest = -1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if ((ch - '0') > largest) {
                    secondLargest = largest;
                    largest = (ch - '0');
                } else if ((ch - '0') > secondLargest && (ch - '0') < largest) {
                    secondLargest = (ch - '0');
                }
            }
        }
        return secondLargest;
    }
}