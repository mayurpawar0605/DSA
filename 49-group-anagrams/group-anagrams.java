class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        // for(String s : strs){
        //     char[] arr = s.toCharArray();
        //     Arrays.sort(arr);
        //     String newStr = new String(arr);

        //     if (!map.containsKey(newStr)) {
        //         map.put(newStr, new ArrayList<>());
        //     }

        //     map.get(newStr).add(s);

        // }
        // return new ArrayList<>(map.values());

        for(String s : strs){
            int[] arr = new int[26];

            for(int i=0; i<s.length();i++){
                arr[s.charAt(i) - 'a']++;
            }
            String code = "";
            for(int i=0; i <26;i++){
                code = code + '#';
                code = code + arr[i];
            }

            if(!map.containsKey(code)){
                map.put(code,new ArrayList<>());
            }
            map.get(code).add(s);
        }

        return new ArrayList<>(map.values());
    }
}