class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        int ans = -1;
        int maxOdd = -1;
        int minEven = Integer.MAX_VALUE;

        Arrays.fill(freq, 0);

        for (char ch : s.toCharArray()) {
            freq[(int)(ch - 'a')]++;
        }

        for (int f : freq) {
            if (f == 0) {
                continue;
            }

            if (f % 2 == 1) {
                maxOdd = Math.max(f, maxOdd);
            }
            else {
                minEven = Math.min(f, minEven);
            }
        }

        return maxOdd - minEven;
    }
}