class Solution {
    public int numberOfSubstrings(String s) {

        // int count = 0;
        // int n = s.length();
        // for(int i = 0;i < n;i++){
        //     int[] arr = new int[3];
        //     for(int j =i;j < n;j++){
        //         char ch = s.charAt(j);
        //         int index = ch - 'a';
        //         arr[index] = 1;

        //         if(arr[0] + arr[1] + arr[2] == 3){
        //             //if we get substring having all three characters at index j
        //             //then after j to n-1 all are valid substrings n-j 
        //             //we dont need to check further
        //             count += n - j;
        //             break;
        //         }
        //     }
        // }

        int n = s.length();
        int i =0;
        int count = 0;
        int lastSeen[] = {-1,-1,-1};

        while(i < n){
            lastSeen[s.charAt(i) - 'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count = count + 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
            i++;
        }
        return count;
    }
}