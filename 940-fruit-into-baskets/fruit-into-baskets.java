class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxFruits = 0;
        int l = 0;
        int r = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(r < n){
            map.put(fruits[r] ,map.getOrDefault(fruits[r],0) + 1);

            if(map.size() > 2){
                map.replace(fruits[l],map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size() <= 2){
                maxFruits = Math.max(maxFruits , r - l + 1);
            }
            r++;
        }

        // while(r < n){
        //     //add freu of current element 
        //     map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

        //     //if map size exceeds 2
        //     //map has 3 unique elements -> we have to shrink till map size less than two
        //     // remove element at l till freq of that element is becomes 0
        //     while(map.size() > 2){
        //         map.replace(fruits[l], map.get(fruits[l]) - 1);
        //         if(map.get(fruits[l]) == 0){
        //             map.remove(fruits[l]);
        //         }
        //         l++;
        //     }
        //     maxFruits = Math.max(maxFruits , r - l + 1);
        //     r++;
        // }

    //    for(int i = 0; i < n; i ++){
    //         HashSet<Integer> set = new HashSet<>();
    //         for(int j = i; j < n; j++){
    //             set.add(fruits[j]);
    //             if(set.size() <= 2){
    //                 int length = j - i + 1;
    //                 maxFruits = Math.max(maxFruits , length);
    //             }else{
    //                 break;
    //             }
    //         }
    //    }
       return maxFruits; 
    }
}