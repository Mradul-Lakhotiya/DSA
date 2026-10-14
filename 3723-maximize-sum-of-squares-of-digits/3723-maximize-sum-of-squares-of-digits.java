class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();

        while (sum > 0) {
            sb.append((char)(Math.min(sum, 9) + '0'));
            sum -= Math.min(sum, 9);
        }

        if (sb.length() > num) {
            return new String("");
        }

        while (sb.length() != num) {
            sb.append("0");
        }

        return sb.toString();
    }
}