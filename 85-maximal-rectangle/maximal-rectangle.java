class Solution {
    public static void findPreviousSmallerIndex(int[] arr, int prev[]) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            //pop useless elements
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                //no previous smaller element found
                prev[i] = -1;
            } else {
                //stack empty nahi hai to useful -> prev smaller element ka index store ho jayega
                prev[i] = st.peek();
            }
            st.push(i);
        }
    }

    public static void findNextSmallerIndex(int[] arr, int next[]) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            //pop useless elements
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                //no previous smaller element found
                next[i] = n;
            } else {
                //stack empty nahi hai to useful -> next smaller element ka index store ho jayega
                next[i] = st.peek();
            }
            st.push(i);
        }
    }

    public int getMaxArea(int[] heights) {

        int n = heights.length;

        //two arrays store indexes of next and previous smaller element
        int prev[] = new int[n];
        int[] next = new int[n];

        findPreviousSmallerIndex(heights, prev);
        findNextSmallerIndex(heights, next);

        int maxArea = -1;

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = next[i] - prev[i] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //convert 2D array Problem in to 1D array problem

        int[] heights = new int[cols];

        int maxArea = -1;

        //each row ko mai base karunga and feed karunga largest area inhistogram and track maxArea
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j] ++;
                }else{
                    //matrix[i][j] == '0'
                    heights[j] = 0;
                }
            }
            //find maxArea -> using function
            int area = getMaxArea(heights);
            //update maxArea
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}