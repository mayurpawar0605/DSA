class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int num : nums){

            //check each digit of num 
            while(num > 0){
                int currDigit =  num % 10;
                //if curr is mathch with digitd given then we get it count ++
                if(currDigit == digit){
                    count++;
                }
                num = num / 10;
            }
        }
        return count;
    }
}