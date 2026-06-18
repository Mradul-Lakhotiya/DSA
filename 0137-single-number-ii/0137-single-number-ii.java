class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int x : nums) {
                if (((1 << i) & x) != 0) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                res = res | (1 << i);
            }
        }

        return res;
    }
}