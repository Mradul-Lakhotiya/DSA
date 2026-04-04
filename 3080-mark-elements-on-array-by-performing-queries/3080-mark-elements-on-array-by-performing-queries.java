class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> {
                if (nums[a] == nums[b]) {
                    return a - b;
                }
                else {
                    return nums[a] - nums[b];
                }
            }
        );

        boolean[] marked = new boolean[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            heap.add(i);
            sum += nums[i];
        }

        long[] res =  new long[m];

        for (int i = 0; i < m; i++) {
            int idx = queries[i][0];
            int k = queries[i][1];

            if (!marked[idx]) {
                sum -= nums[idx];
            }

            marked[idx] = true;


            while (!heap.isEmpty() &&  k > 0) {
                int temp = heap.poll();

                if (marked[temp]) {
                    continue;
                }
                else {
                    sum -= nums[temp];
                    k--;
                    marked[temp] = true;
                }
            }

            res[i] = sum;

            if (heap.isEmpty()) {
                return res;
            }
        }

        return res;
    }
}