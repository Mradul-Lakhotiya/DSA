class Solution {
    public int titleToNumber(String str) {
        int res = 0;

        for (char ch : str.toCharArray()) {
            int curr = (ch - 'A') + 1;
            res = res * 26 + curr;
        }

        return res;
    }
}