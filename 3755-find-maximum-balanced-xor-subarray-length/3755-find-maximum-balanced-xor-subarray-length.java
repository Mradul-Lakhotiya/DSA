class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<Long, Integer> first = new HashMap<>();

        int xor = 0;
        int balance = 0;
        int ans = 0;

        first.put(pack(0, 0), -1);

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];

            if ((nums[i] & 1) == 0) {
                balance--;
            }
            else {
                balance++;
            }

            long key = pack(xor, balance);

            if (first.containsKey(key)) {
                ans = Math.max(ans, i - first.get(key));
            } 
            else {
                first.put(key, i);
            }
        }

        return ans;
    }

    private long pack(int xor, int balance) {
        return (((long) xor) << 32) | (balance & 0xffffffffL);
    }
}