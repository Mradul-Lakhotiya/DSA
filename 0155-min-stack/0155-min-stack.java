class MinStack {
    private Deque<int[]> st;

    public MinStack() {
        st = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int minVal = val;

        if (!st.isEmpty()) {
            int[] temp = st.peek();

            if (temp[1] < minVal) {
                minVal = temp[1];
            }
        }

        st.offerFirst(new int[]{val, minVal});
    }
    
    public void pop() {
        st.pollFirst();
    }
    
    public int top() {
        return st.peekFirst()[0];
    }
    
    public int getMin() {
        return st.peekFirst()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */