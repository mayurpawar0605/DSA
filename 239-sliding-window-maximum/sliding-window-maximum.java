class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int [n-k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < k; i++){
            while(!q.isEmpty() && nums[q.getLast()] < nums[i]){
                q.removeLast();
            }
            q.addLast(i);
        }

        ans[0] = nums[q.getFirst()];
        int idx = 1;

        for(int i = k ; i < n; i++){
            while(!q.isEmpty() && nums[q.getLast()] < nums[i]){
                q.removeLast();
            }
            if(!q.isEmpty() && q.getFirst() <= i-k){
                q.removeFirst();
            }
            q.addLast(i);
            ans[idx++] = nums[q.getFirst()]; 
        }
        return ans;

        // for(int i = 0; i < n-k+1; i++){
        //     int max = Integer.MIN_VALUE;
        //     for(int j = i; j < i+k; j++){
        //         max = Math.max(max,nums[j]);
        //     }
        //     ans[i] = max;
        // }
        // return ans;
    }
}