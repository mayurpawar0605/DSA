class Solution {
    //My solution 

    // static boolean check(String s,String t,HashMap<Character,Integer> maps,HashMap<Character,Integer> mapt){
    //     for(char ch : mapt.keySet()){
    //         if(!maps.containsKey(ch)){
    //             return false;
    //         }
    //         if(maps.get(ch) < mapt.get(ch)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public String minWindow(String s, String t) {
    //     int l = 0;
    //     int r = 0;

    //     HashMap<Character,Integer> mapt = new HashMap<>();
    //     int m = t.length();
    //     int i = 0;
    //     while(i < m){
    //         mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0) + 1);
    //         i++;
    //     }

    //     HashMap<Character,Integer> maps = new HashMap<>();
    //     int n = s.length();
    //     int minLength = Integer.MAX_VALUE;

    //     String ans = "";
    //     while(r < n){
    //         maps.put(s.charAt(r),maps.getOrDefault(s.charAt(r),0) + 1);
                
    //         while(check(s,t,maps,mapt) == true){
    //             int length = r - l + 1;
    //             if(minLength > length){
    //                 minLength = length;
    //                 ans = s.substring(l,r+1);
    //             }

    //             char ch = s.charAt(l);
    //             maps.replace(ch,maps.get(ch) - 1);
    //             if(maps.get(ch) == 0){
    //                 maps.remove(ch);
    //             }
    //             l++;
    //         }
    //         r++;
    //     }
    //     return ans;
    // }


    //Brute force 

    // public String minWindow(String s, String t) {
    //     int minLen = Integer.MAX_VALUE;
    //     int sIndex = -1;
    //     int n = s.length();
    //     int m = t.length();

    //     for(int i = 0;i < n;i++){
    //         int[] arr = new int[256];
    //         int count = 0;
    //         for(int j= 0; j < m; j++){
    //             char ch = t.charAt(j);
    //             arr[ch]++;
    //         }
    //         for(int j = i; j < n; j++){
    //             //if it is pre inserted 
    //             char ch = s.charAt(j);
    //             if(arr[ch] > 0){
    //                 count ++;
    //             }
    //             arr[ch]--;
    //             if(count == m){
    //                 if(minLen > j - i + 1){
    //                     minLen = j - i + 1;
    //                     sIndex = i;
    //                 }
    //                 break;
    //             }
    //         }

    //     }
    //     if(sIndex == -1){
    //         return "";
    //     }
    //     String ans = s.substring(sIndex,minLen + sIndex);
    //     return ans;

    // }

    //optimization

    public String minWindow(String s, String t){
        int[] arr = new int[256];
        int l = 0; int r =0;
        int minLen = Integer.MAX_VALUE; int sIndex = -1;
        int n = s.length();
        int m = t.length();
        int count = 0;

        for(int i = 0 ; i < m; i++){
            arr[t.charAt(i)] ++;
        }

        while(r < n){
            if(arr[s.charAt(r)] > 0){
                count++;
            }
            arr[s.charAt(r)] --;

            while(count == m){
                if(minLen > r - l + 1){
                    minLen = r - l + 1;
                    sIndex = l;
                }
                //shrink 
                arr[s.charAt(l)] ++;
                if(arr[s.charAt(l)] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex,sIndex+minLen);
    }
    
}