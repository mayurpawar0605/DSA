class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String newStr = new String(arr);

            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }

            map.get(newStr).add(s);

        }
        return new ArrayList<>(map.values());
    }
}