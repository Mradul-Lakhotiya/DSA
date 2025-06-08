class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            getNumbers(i, n, res);
        }

        return res;
    }

    private void getNumbers(int currNum, int limit, List<Integer> res) {
        if (currNum > limit) {
            return;
        }

        res.add(currNum);

        for (int i = 0; i <= 9; i++) {
            int nextNum = currNum * 10 + i;

            if (nextNum <= limit) {
                getNumbers(nextNum, limit, res);
            }
            else {
                break;
            }
        }
    }
}