class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int[] lastIdx = new int[]{-1, -1, -1};

        for (int i = 0; i < n; i++) {
            lastIdx[s.charAt(i) - 'a'] = i;

            res += 1 + Math.min(lastIdx[0], Math.min(lastIdx[1], lastIdx[2]));
        }

        return res;
    }
}