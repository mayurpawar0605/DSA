class StockSpanner {

    private Deque<int[]> st;
    //0 index = price
    //1 index = span

    public StockSpanner() {
        //constructor
        st = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;

        //monotonic pattern 
        while(!st.isEmpty() && st.peek()[0] <= price){
            span = span + st.peek()[1];
            st.pop();
        }

        st.push(new int[] {price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */