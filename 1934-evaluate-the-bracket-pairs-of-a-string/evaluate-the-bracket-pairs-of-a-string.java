class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        

        HashMap<String,String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0),list.get(1));
        }


        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '('){
                int j = i + 1;
                StringBuilder key = new StringBuilder();
                while(s.charAt(j) != ')'){
                    key.append(s.charAt(j));
                    j++;
                }
                //we get key from i to j 
                String listKey = key.toString();
                
                String val = "?";
                if(map.containsKey(listKey)){
                    val = map.get(listKey);
                }
                
                ans.append(val);
                i = j + 1;
            }else{
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}