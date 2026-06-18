class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int x : nums) {
            xor ^= x;
        }

        int bit = 0;
        for (; bit < 32; bit++) {
            if (((1 << bit) & xor) != 0) {
                break;
            }
        }

        int a = 0;
        int b = 0;

        for (int x : nums) {
            if (((1 << bit) & x) != 0) {
                a ^= x;
            }
            else {
                b ^= x;
            }
        }

        return new int[]{a, b};
    }
}