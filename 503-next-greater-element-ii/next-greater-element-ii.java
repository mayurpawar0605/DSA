class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = n-2; i >= 0; i--){
            st.push(i);
        }
       
        for (int i = n - 1; i >= 0; i--) {
            //monotonic stack pattern
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i] = nums[st.peek()];
            }else{
                ans[i] = -1;
            }
            st.push(i);
        }

        return ans;
    }
}