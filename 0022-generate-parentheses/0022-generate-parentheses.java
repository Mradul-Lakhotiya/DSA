class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        helper(0, n, sb);
        return res;
    }

    void helper(int open, int n, StringBuilder sb) {
        if (n == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }

        if (n != 0) {
            sb.append('(');
            helper(open + 1, n - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open != 0) {
            sb.append(')');
            helper(open - 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}