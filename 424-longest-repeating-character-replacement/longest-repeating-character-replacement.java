class Solution {
    public int characterReplacement(String s, int k) {
        // int n = s.length();
        // int maxLen = 0;
        // for(int i = 0; i < n; i ++){
        //     int[] arr = new int [26];
        //     int maxF = 0;
        //     for(int j = i; j < n; j++){
        //         char ch = s.charAt(j);
        //         arr[ch - 'A'] ++;
        //         maxF = Math.max(arr[ch - 'A'] , maxF);
        //         int length = j-i + 1;
        //         int changes = length - maxF;
        //         if(changes <= k){
        //             maxLen = Math.max(maxLen,length);
        //         }
        //         else{ 
        //             break;
        //         }
        //     }
        // }
        // return maxLen;

        // int l = 0;
        // int r = 0;
        // int maxLen = 0;
        // int maxF = 0;
        // int[] arr = new int [26];
        // int n = s.length();

        // while(r < n){
        //     //increase freq of current char by 1
        //     arr[s.charAt(r) - 'A'] ++;
        //     maxF = Math.max(maxF, arr[s.charAt(r) -'A']);

        //     while((r - l + 1) - maxF > k){
        //         //shrink -> maxF exceeds k
        //         arr[s.charAt(l) - 'A'] --;
        //         for(int i = 0; i < 26;i ++){
        //             maxF = Math.max(maxF,arr[i]);
        //         }
        //         l++;
        //     }
        //     //valid case
        //     if((r - l + 1) - maxF <= k){
        //         maxLen = Math.max(maxLen, r - l + 1);
        //     }
        //     r++;

        // }
        // return maxLen;


        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxF = 0;
        int[] arr = new int [26];
        int n = s.length();

        while(r < n){
            //increase freq of current char by 1
            arr[s.charAt(r) - 'A'] ++;
            maxF = Math.max(maxF, arr[s.charAt(r) -'A']);

            if((r - l + 1) - maxF > k){
                //shrink -> maxF exceeds k
                arr[s.charAt(l) - 'A'] --;
                l++;
            }
            //valid case
            if((r - l + 1) - maxF <= k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;

        }
        return maxLen;

    }
}