class Solution {
    TreeSet<String> ans;

    public List<String> braceExpansionII(String expression) {
        ans = new TreeSet<>();
        helper(expression);
        return new ArrayList<>(ans);
    }

    void helper(String s) {
        int r = s.indexOf('}');

        if (r == -1) {
            ans.add(s);
            return;
        }

        int l = s.lastIndexOf('{', r);

        String left = s.substring(0, l);
        String right = s.substring(r + 1);

        String in = s.substring(l + 1, r);

        for (String p : in.split(",")) {
            helper(left + p + right);
        }
    }
}