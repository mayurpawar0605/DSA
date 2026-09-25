class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap<String,List<String>> map = new HashMap<>();

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

        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] arr = new int[26];

            for(int i=0; i<s.length();i++){
                arr[s.charAt(i) - 'a']++;
            }
            StringBuilder code = new StringBuilder();
            for(int i=0; i <26;i++){
                code.append('#');
                code.append(arr[i]);
            }

            String codee = code.toString();
            if(!map.containsKey(codee)){
                map.put(codee,new ArrayList<>());
            }
            map.get(codee).add(s);
        }

        return new ArrayList<>(map.values());
    }
}