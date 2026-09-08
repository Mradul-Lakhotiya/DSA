class Solution {
    List<String> res = new ArrayList<>();
    String num;
    int target;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;

        helper(0, new StringBuilder(), 0, 0);

        return res;
    }

    void helper(int i, StringBuilder curr, long value, long prev) {
        if (i == num.length()) {
            if (value == target) {
                res.add(curr.toString());
            }
            return;
        }

        int len = curr.length();

        for (int j = i; j < num.length(); j++) {
            if (j > i && num.charAt(i) == '0') {
                break;
            }

            String part = num.substring(i, j + 1);
            long current = Long.parseLong(part);

            if (i == 0) {
                curr.append(part);
                helper(j + 1, curr, current, current);
                curr.setLength(len);
            } 
            else {
                // +
                curr.append("+").append(part);
                helper(j + 1, curr, value + current, current);
                curr.setLength(len);

                // -
                curr.append("-").append(part);
                helper(j + 1, curr, value - current, -current);
                curr.setLength(len);

                // *
                curr.append("*").append(part);
                helper(
                    j + 1,
                    curr,
                    value - prev + prev * current,
                    prev * current
                );

                curr.setLength(len);
            }
        }
    }
}