class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n2];

        int i = 0;
        while (i < n1) {
            int j = 0;
            while (j < n2) {
                if (nums1[i] == nums2[j] && !visited[j]) {
                    list.add(nums1[i]);
                    visited[j] = true;
                    break;
                }
                j++;
            }
            i++;
        }
        int ans[] = new int[list.size()];
        int k = 0;
        for (int n : list) {
            ans[k] = n;
            k++;
        }
        return ans;

    }
}