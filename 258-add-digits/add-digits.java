class Solution {
    public int addDigits(int num) {
        while(num > 9){

            int num1 = num % 10;
            num = num / 10;

            int num2 = num % 10;
            num = num / 10;

            num += num1 + num2;
        }

        return num;
    }
}