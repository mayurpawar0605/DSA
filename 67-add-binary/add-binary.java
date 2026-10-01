class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();

        StringBuilder ans = new StringBuilder();

        int carry = 0;
        int i =m - 1;
        int j = n- 1;
        while(i >= 0 && j >= 0){
            int numA = a.charAt(i) - '0';
            int numB = b.charAt(j) - '0';

            int currNum = carry + numA + numB;

            if(currNum < 2){
                if(currNum == 1) ans.insert(0,'1');
                if(currNum == 0) ans.insert(0,'0');
                carry = 0;
            }else{
                // ans is 2 or greater than 2
                if(currNum == 2) ans.insert(0,'0');
                if(currNum == 3) ans.insert(0,'1');
                carry = 1;
            }
            i--;
            j--;
        }

        //if a gets empty
        while(i >= 0){
            int numA = a.charAt(i) - '0';
            int currNum = numA + carry;
            if(currNum < 2){
                if(currNum == 1) ans.insert(0,'1');
                if(currNum == 0) ans.insert(0,'0');
                carry = 0;
            }else{
                // ans is 2 or greater than 2
                if(currNum == 2) ans.insert(0,'0');
                if(currNum == 3) ans.insert(0,'1');
                carry = 1; 
            }
            i--;
        }
        //if b gets empty
         while(j >= 0){
            int numB = b.charAt(j) - '0';
            int currNum = numB + carry;
            if(currNum < 2){
                if(currNum == 1) ans.insert(0,'1');
                if(currNum == 0) ans.insert(0,'0');
                carry = 0;
            }else{
                // ans is 2 or greater than 2
                if(currNum == 2) ans.insert(0,'0');
                if(currNum == 3) ans.insert(0,'1');
                carry = 1; 
            }
            j--;
        }

        //if carry is greater than 0;
        if(carry > 0){
            ans.insert(0 , '1');
        }

        return ans.toString();
    }
}