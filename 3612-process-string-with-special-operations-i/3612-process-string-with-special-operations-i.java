class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                sb.append(sb);
            }
            else if (ch == '%') {
                sb = sb.reverse();
            }
            else if (ch == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}