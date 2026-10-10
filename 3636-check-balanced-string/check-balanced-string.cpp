class Solution {
public:
    bool isBalanced(string num) {
        int sum =0;
        int sum1 = 0;
        int n = num.size();
        for(int i=0;i<n;i++){
            int digit = num[i] - '0';
            if(i%2==0){
                sum = sum + digit;
            }
            else{
                sum1 = sum1 + digit;
            }
        }
        if(sum == sum1){
            return true;
        }
        return false;
    }
};