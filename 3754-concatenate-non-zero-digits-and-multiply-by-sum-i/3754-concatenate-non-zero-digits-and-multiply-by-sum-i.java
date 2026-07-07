class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        long mul = 0;

        for (char ch : s.toCharArray()) {
            if (ch != '0') {
                sb.append(ch);
                mul += (long)(ch - '0');
            }
        }

        if (sb.length() == 0) {
            return 0;
        }

        long val = Long.parseLong(sb.toString());

        return val * mul;
    }
}