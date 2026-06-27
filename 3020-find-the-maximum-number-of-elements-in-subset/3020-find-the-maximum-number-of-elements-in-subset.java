class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        if (map.containsKey(1L)) {
            int one = map.get(1L);
            ans = (one % 2 == 0) ? one - 1 : one;
        }

        for (long num : map.keySet()) {
            if (num == 1) {
                continue;
            }

            long curr = num;
            int len = 0;

            while (map.getOrDefault(curr, 0) >= 2) {
                len += 2;
                curr *= curr;

                if (curr > 1000000000000000000L) {
                    break;
                }
            }

            if (map.getOrDefault(curr, 0) >= 1) {
                len++;
            } 
            else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}