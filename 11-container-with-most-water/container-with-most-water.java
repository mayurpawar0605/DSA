class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = -1;
        int i =0;
        int j = n-1;


        while(i <= j){
            int length = j - i;
            int heightt = Math.min(height[i],height[j]);
            int area = length * heightt;
            ans = Math.max(ans,area);
            if(height[i] >= height[j]){
                j--;
            }else{
                i++;
            }
        }
        return ans;
    }
    
}