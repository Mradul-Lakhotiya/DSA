class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        for (int i = 0; i < (n - k + 1); i++) {
            res[i] = findXsum(Arrays.copyOfRange(nums, i, i + k), x);
        }

        return res;
    }

    private int findXsum(int[] arr, int x) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int a : arr) {
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return b.getKey() - a.getKey();
            }

            return b.getValue() - a.getValue();
        });

        maxHeap.addAll(freq.entrySet());

        int sum = 0;

        for (int i = 0; i < x && !maxHeap.isEmpty(); i++) {
            Map.Entry<Integer, Integer> e = maxHeap.poll();
            sum += e.getKey() * e.getValue();
        }

        return sum;
    }
}