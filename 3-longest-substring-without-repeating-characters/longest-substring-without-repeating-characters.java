class Solution {
   
    public int lengthOfLongestSubstring(String s) {
        
        // int n = s.length();
        // int maxLen = 0;

        // for(int i = 0; i < n ; i ++){
        //     int[] arr = new int [256];
        //     for(int j = i ; j < n; j ++){
        //         char ch = s.charAt(j);
        //         int index = ch;
        //         if(arr[index] == 1){
        //             break;
        //         }
        //         int length = j - i + 1;
        //         maxLen = Math.max(length,maxLen);
        //         arr[index]++;
        //     }
        // }
        // return maxLen;

        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while (r < n){
            char ch = s.charAt(r);
            //if character repeats
            if(map.containsKey(ch)){
                //check for char repeats inside substring 
                //repeated char index is greater than l -> update it
                if(map.get(ch) >= l){
                    //we need to update it 
                    l = map.get(ch) + 1;
                }   
            }
            int length = r - l + 1;
                maxLen = Math.max(length,maxLen);

                //add current charater with current index in map
                map.put(ch,r);
                //check for nex character 
                r++;
        }
        return maxLen;
    }
}