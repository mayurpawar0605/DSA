class Solution {
    public static boolean checkFreq(int[] count1 , int[] count2){
        for (int i = 0;i < 26; i++){
            if (count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean checkInclusion(String subStr,String str){
        if(subStr.length() > str.length()){
            return false;
        }
        //create freq table of subStr
        int count1[] = new int[26];
        for(int i = 0; i < subStr.length(); i++){
            char ch = subStr.charAt(i);
            int index = ch - 'a';
            count1[index]++;
        }

        //create freq table for str for first window
        int windowLength = subStr.length();
        int count2[] = new int [26];
        int i = 0;
        for ( i = 0; i < windowLength; i++){
            char ch = str.charAt(i);
            int index = ch - 'a';
            count2[index]++;
        }

        //checking for next windows
        if (checkFreq(count1,count2) == true){
            return true;
        }else {
            //if not matching check for next windows
            while (i < str.length()){
                //add next
                char newChar = str.charAt(i);
                int indexOfNewChar = newChar - 'a';
                count2[indexOfNewChar]++;

                //remove previous element of window
                 int oldCharIndex = i - windowLength;
                 char oldChar = str.charAt(oldCharIndex);
                 int oldCharFreqIndex = oldChar - 'a';
                 count2[oldCharFreqIndex]--;

                 //compare with count 1
                if (checkFreq(count1,count2) == true){
                    return true;
                }

                i++;
            }
        }
        return false;
    }
}