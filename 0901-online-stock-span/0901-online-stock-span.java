class StockSpanner {
    List<Integer> list;
    int size;

    public StockSpanner() {
        list = new ArrayList<>();
        size = 0;
    }
    
    public int next(int price) {
        int res = 1;
        list.add(price);
        size++;
        
        for (int i = size - 2; i >= 0; i--) {
            if (list.get(i) <= price) {
                res++;
            }
            else {
                return res;
            }
        }

        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */