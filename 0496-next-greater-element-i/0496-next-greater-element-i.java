class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;

        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }

        int[] nextMax = nextGreaterElement(nums2);
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            res[i] = nextMax[map.get(nums1[i])];
        }

        return res;
    }

    private int[] nextGreaterElement(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peekFirst() <= nums[i]) {
                st.pollFirst();
            }

            res[i] = st.isEmpty() ? -1 : st.peekFirst();

            st.offerFirst(nums[i]);
        }

        return res;
    }
}