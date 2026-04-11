class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int res = n;
        int l = 0;
        int r = (n + 1) / 2;

        while (l < n / 2 && r < n) {
            if (nums.get(l) < nums.get(r)) {
                res -= 2;
            }
            l++;
            r++;
        }

        return res;
    }
}