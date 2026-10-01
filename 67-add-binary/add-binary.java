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

            int sum =  carry + numA + numB;
            ans.insert(0,sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        //if a gets empty
        while(i >= 0){
            int numA = a.charAt(i) - '0';
            int sum =  carry + numA;
            ans.insert(0,sum % 2);
            carry = sum / 2;
            i--;
        }
        //if b gets empty
         while(j >= 0){
            int numB = b.charAt(j) - '0';
            int sum =  carry + numB;
            ans.insert(0,sum % 2);
            carry = sum / 2;
            j--;
        }

        //if carry is greater than 0;
        if(carry > 0){
            ans.insert(0 , '1');
        }

        return ans.toString();
    }
}