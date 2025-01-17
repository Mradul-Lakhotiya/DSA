class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;

        for (int num : derived) {
            res ^= num;
        }

        return res == 0;
    }
}