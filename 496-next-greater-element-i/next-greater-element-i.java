class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        
        Deque<Integer> st = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i = n - 1; i >= 0; i--) {
            //monotonic stack pattern
            while (!st.isEmpty() && nums2[st.peek()] <= nums2[i]) {
                st.pop();
            }

            if(!st.isEmpty()){
                map.put(nums2[i],nums2[st.peek()]);
            }else{
                map.put(nums2[i],-1);
            }
            st.push(i);
        }


        n = nums1.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            ans[i] = map.get(nums1[i]);
        }
        
        return ans;
    }
}