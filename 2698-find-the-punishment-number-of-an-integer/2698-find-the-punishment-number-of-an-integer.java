class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (isValidPartition(String.valueOf(square), i, 0, 0)) {
                ans += square;
            }
        }

        return ans;
    }

    private boolean isValidPartition(String str, int target, int index, int sum) {
        if (index == str.length()) {
            return sum == target;
        }

        int num = 0;
        for (int i = index; i < str.length(); i++) {
            num = num * 10 + (str.charAt(i) - '0');
            if (isValidPartition(str, target, i + 1, sum + num)) {
                return true;
            }
        }
        return false;
    }
}
