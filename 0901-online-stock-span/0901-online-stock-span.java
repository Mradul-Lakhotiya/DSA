class StockSpanner {
    Deque<int[]> st;

    public StockSpanner() {
        st = new ArrayDeque<>();    
    }
    
    public int next(int price) {
        int ans = 1;

        while (!st.isEmpty() && st.peekFirst()[0] <= price) {
            ans += st.pollFirst()[1];
        }

        st.offerFirst(new int[]{price, ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */