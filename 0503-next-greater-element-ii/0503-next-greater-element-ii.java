class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];

            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }

            if (i < n)  {
                if (!st.isEmpty()) {
                    res[i] = st.peek();
                }
            }

            st.push(num);
        }

        return res;
    }
}