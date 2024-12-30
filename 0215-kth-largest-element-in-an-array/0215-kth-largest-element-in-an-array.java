class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        // for (int num : nums) {
        //     minHeap.add(num);
            
        //     if (minHeap.size() > k) {
        //         minHeap.poll();
        //     }
        // }

        // return minHeap.peek();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int hashKey = max - min + 1;
        int[] arr = new int[hashKey];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - min]++;
        }

        for (int i = hashKey - 1; i >= 0; i--) {
            count += arr[i];

            if (count >= k) {
                return i + min;
            }
        }

        return -1;
    }
}