class Solution {
    static boolean check(String s, String goal, int i, int j){
        while(j < goal.length()){
            if(i==s.length()){
                i = 0;
            }

            if(s.charAt(i) != goal.charAt(j)){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        
        int i = 0;
        int j = 0;

        while(i < s.length()){
            if(s.charAt(i) == goal.charAt(j)){
                if(check(s,goal,i,j)){
                    return true;
                }
            }
            i++;
        }

        return false;
        
    }
}