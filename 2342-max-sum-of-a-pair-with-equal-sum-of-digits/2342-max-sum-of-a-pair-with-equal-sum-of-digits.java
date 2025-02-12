class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> group = new HashMap<>();
        int n = nums.length;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            int temp = findSum(nums[i]);

            group.putIfAbsent(temp, new PriorityQueue<Integer>(Collections.reverseOrder()));

            group.get(temp).add(nums[i]);
        }

        for (int key : group.keySet()) {
            PriorityQueue<Integer> current = group.get(key);

            if (current.size() >= 2) {
                ans = Math.max(ans, current.poll() + current.poll());
            }
        }

        return ans;
    }

    private int findSum(int num) {
        int ans = 0;

        while (num != 0) {
            int temp = num % 10;
            num /= 10;
            ans += temp; 
        }

        return ans;
    }
}