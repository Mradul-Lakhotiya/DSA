class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int len = 1;

                while (set.contains(x + len)) {
                    len++;
                }

                max = Math.max(len, max);
            }
        }

        return max;
    }
}