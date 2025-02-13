class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int ans = 0;

        for (int num : nums) {
            pq.add((long)num);
        }

        while (pq.size() > 1 && pq.peek() < k ) {
            long x = pq.poll();
            long y = pq.poll();

            pq.add(Math.min(x , y) * 2 + Math.max(x, y));
            ans++;
        }

        return ans;
    }
}