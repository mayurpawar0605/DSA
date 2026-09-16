class Solution {
    static boolean check(String s,String t,HashMap<Character,Integer> maps,HashMap<Character,Integer> mapt){
        for(char ch : mapt.keySet()){
            if(!maps.containsKey(ch)){
                return false;
            }
            if(maps.get(ch) < mapt.get(ch)){
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;

        HashMap<Character,Integer> mapt = new HashMap<>();
        int m = t.length();
        int i = 0;
        while(i < m){
            mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0) + 1);
            i++;
        }

        HashMap<Character,Integer> maps = new HashMap<>();
        int n = s.length();
        int minLength = Integer.MAX_VALUE;

        String ans = "";
        while(r < n){
            maps.put(s.charAt(r),maps.getOrDefault(s.charAt(r),0) + 1);
                
            while(check(s,t,maps,mapt) == true){
                int length = r - l + 1;
                if(minLength > length){
                    minLength = length;
                    ans = s.substring(l,r+1);
                }

                char ch = s.charAt(l);
                maps.replace(ch,maps.get(ch) - 1);
                if(maps.get(ch) == 0){
                    maps.remove(ch);
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}