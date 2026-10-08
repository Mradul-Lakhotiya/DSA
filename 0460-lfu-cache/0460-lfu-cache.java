class LFUCache {
    class Value {
        int key;
        int count;
        int val;
        long time;

        Value(int key, int val) {
            this.key = key;
            this.val = val;
            this.count = 1;
            this.time = timer++;
        }

        int get() {
            count++;
            time = timer++;
            return val;
        }
    }

    int c;
    long timer = 0;

    HashMap<Integer, Value> map;
    PriorityQueue<Value> heap;

    public LFUCache(int capacity) {
        c = capacity;
        map = new HashMap<>();

        heap = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count) {
                return Integer.compare(a.count, b.count);
            }

            return Long.compare(a.time, b.time);
        });
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Value val = map.get(key);

        heap.remove(val);

        int res = val.get();

        heap.add(val);

        return res;
    }

    public void put(int key, int value) {
        if (c == 0) {
            return;
        }

        if (map.containsKey(key)) {
            Value val = map.get(key);

            heap.remove(val);

            val.val = value;
            val.count++;
            val.time = timer++;

            heap.add(val);

            return;
        }

        if (map.size() == c) {
            Value removed = heap.poll();
            map.remove(removed.key);
        }

        Value val = new Value(key, value);

        map.put(key, val);
        heap.add(val);
    }
}