class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        if (numRows == 0) {
            return ans;
        }

        ans.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = ans.get(i - 1);
            List<Integer> next = new ArrayList<>();
            next.add(1);

            for (int j = 1; j < prev.size(); j++) {
                next.add(prev.get(j - 1) + prev.get(j));
            }

            next.add(1);

            ans.add(next);
        }

        return ans;
    }
}