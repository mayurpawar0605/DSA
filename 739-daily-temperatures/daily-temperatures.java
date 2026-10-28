class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];

        // int index = 0;
        

        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         if (temperatures[i] < temperatures[j]) {
        //             ans[index] = j - i;
        //             break;
        //         }
        //     }
        //     index++;
        // }
        // return ans;


        Deque<Integer>  st = new ArrayDeque<>();

        for(int i = 0 ; i < n; i++){
            //for each inder x we will find ans using stack
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                //fount a warmer day
                int prevDay = st.pop();
                ans[prevDay] = i - prevDay;
            }
            //insert curr temp
            st.push(i);
        }
        return ans;
    }
}













