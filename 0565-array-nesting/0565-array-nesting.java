class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int max = 0;

        for (int k = 0; k < n; k++) {
            if (visited[k]) {
                continue;
            }

            int len = 0;
            int start = k;

            while (!visited[start]) {
                visited[start] = true;
                start = nums[start];
                len++;
            }

            max = Math.max(max, len);
        }

        return max;
    }
}