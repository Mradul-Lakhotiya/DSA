class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int i = Math.max(num1, 101); i <= num2; i++) {
            ans += getWaves(i);
        }

        return ans;
    }

    int getWaves(int num) {
        int res = 0;

        int right = num % 10;
        num /= 10;

        int mid = num % 10;
        num /= 10;

        while (num > 0) {
            int left = num % 10;

            if ((mid > left && mid > right) ||
                (mid < left && mid < right)) {
                res++;
            }

            right = mid;
            mid = left;
            num /= 10;
        }

        return res;
    }
}