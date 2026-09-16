class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr1);
        int[] temp = arr1.clone();
        HashMap<Integer,Integer> map = new HashMap<>();
        

        //hashmap for array 1
        for(int num : arr1){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int i = 0;
        for(int num : arr2){
            int freq = map.get(num);
            while(freq > 0){
                arr1[i] = num;
                i++;
                freq--;
            }
        }

        //for those elements which are not in arr2
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num : arr2){
            mp.put(num,mp.getOrDefault(num,0) + 1);
        }

        for(int num : temp){
            if(!mp.containsKey(num)){
                arr1[i] = num;
                i++;
            }
        }
        return arr1;
    }
}