class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;

        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,Integer> first = new HashMap<>();
        Map<Integer,Integer> last = new HashMap<>();

        for(int i = 0; i < n; i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);

            if(!first.containsKey(nums[i])){
                first.put(nums[i],i);
            }

            last.put(nums[i],i);
        }

        int degree = 0;

        for(int key : freq.keySet()){
            int currDegree = freq.get(key);
            degree = Math.max(degree,currDegree);
        }

        //we need to find smallest possiblr length
        //first and last index of elements that ahve same degeree
        //take minimum of them
        int min = nums.length;
        for(int i = 0; i < n; i++){
            if(freq.get(nums[i]) == degree){
                int firstIdx = first.get(nums[i]);
                int lastIdx = last.get(nums[i]);
                int total = lastIdx - firstIdx + 1;
                min = Math.min(min,total);
            }
        }
        return min;
    }
}