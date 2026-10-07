class Solution {
    String s;
    int n;
    Set<String> res;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        this.n = s.length();
        this.res = new HashSet<>();

        int k = getInvaildCount(s);

        helper(0, k, new StringBuilder());

        return new ArrayList<>(res);
    }

    void helper(int i, int k, StringBuilder sb) {
        if (i == n) {
            if (k == 0 && isVaild(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }

        if (n - i < k) {
            return;
        }

        char ch = s.charAt(i);

        if (k > 0 && (ch == '(' || ch == ')')) {
            helper(i + 1, k - 1, sb);
        }

        sb.append(ch);
        helper(i + 1, k, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    int getInvaildCount(String s) {
        int oc = 0;
        int cc = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                oc++;
            } 
            else if (ch == ')') {

                if (oc == 0) {
                    cc++;
                } 
                else {
                    oc--;
                }
            }
        }

        return oc + cc;
    }

    boolean isVaild(String s) {
        return getInvaildCount(s) == 0;
    }
}