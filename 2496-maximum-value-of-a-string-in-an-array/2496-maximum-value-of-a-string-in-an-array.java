class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;

        for (String s : strs) {
            try {
                int num = Integer.parseInt(s);
                max = Math.max(max, num);
            }
            catch (NumberFormatException e) {
                max = Math.max(max, s.length());
            }
        }

        return max;
    }
}