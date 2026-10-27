class Solution {
    public String decodeString(String s) {
        Deque<Integer> countSt = new ArrayDeque<>();
        Deque<StringBuilder> stringSt = new ArrayDeque<>();

        int num = 0;
        StringBuilder curr = new StringBuilder();

        for(char ch : s.toCharArray()){
            //case 1
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if(ch == '['){
                countSt.push(num);
                stringSt.push(curr);
                //new values to be initialise
                num = 0;
                curr = new StringBuilder();
            }else if(ch == ']'){
                int repeatCount = countSt.pop();
                StringBuilder prev = stringSt.pop();

                for(int i = 1 ; i <= repeatCount ;i++){
                    prev.append(curr);
                }
                //IMP
                curr = prev;

            }else{
                //alphabate string
                curr.append(ch);
            }
        }
        return curr.toString();

    }
}