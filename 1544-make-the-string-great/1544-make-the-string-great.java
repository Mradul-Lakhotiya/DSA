class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() &&
                Math.abs(st.peek() - ch) == 32) {
                st.pop();
            }
            else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }
}