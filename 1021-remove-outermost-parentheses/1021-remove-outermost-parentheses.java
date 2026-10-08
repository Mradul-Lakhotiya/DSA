class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int temp = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (temp != 0) {
                    sb.append(ch);
                }

                temp++;
            }
            else if (ch == ')') {
                if (temp != 1) {
                    sb.append(ch);
                }

                temp--;
            }
        }

        return sb.toString();
    }
}