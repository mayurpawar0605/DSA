class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;


        for(int i = n-1; i >= 0; i--){
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if(carry > 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            int index = 1;
            for(int num : digits){
                newDigits[index] = num;
                index ++;
            }
            return newDigits;
        }



        return digits;
    }
}