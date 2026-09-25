class Solution {
    public int value(char ch){
        if(ch == 'I') return 1;
        if(ch == 'V') return 5;
        if(ch == 'X') return 10;
        if(ch == 'L') return 50;
        if(ch == 'C') return 100;
        if(ch == 'D') return 500;
        return 1000;
    }
    public int romanToInt(String s) {
        int n = s.length();
        int digit = 0;
        for(int i =0 ; i < n; i++){
            int current = value(s.charAt(i));

            if(i+1 < n && current < value(s.charAt(i+1))){
                digit -= current;
            }else{
                digit += current;
            }
        }
        return digit;
    }
}