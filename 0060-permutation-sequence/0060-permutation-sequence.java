class Solution {
    List<String> per = new ArrayList<>();

    public String getPermutation(int n, int k) {
        boolean[] taken = new boolean[n];
        helper(new StringBuilder(), 0, taken, n);
        Collections.sort(per);
        return per.get(k - 1);
    }

    private void helper(StringBuilder temp, int count, boolean[] taken, int n) {
        if (count == n) {
            per.add(temp.toString());
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!taken[j]) {
                taken[j] = true;
                temp.append(j + 1);
                helper(temp, count + 1, taken, n);
                temp.deleteCharAt(temp.length() - 1);
                taken[j] = false;
            }
        }
    }
}