class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        List<Integer> idxs = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                idxs.add(i);
            }
        }

        if (idxs.isEmpty()) {
            return -1;
        }

        int res = Integer.MAX_VALUE;

        for (int pos : idxs) {
            if (pos > startIndex) {
                res = Math.min(pos - startIndex, Math.min((n - pos) + startIndex, res));
            }
            else {
                res = Math.min(startIndex - pos, Math.min((n - startIndex) + pos, res));
            }
        }

        return res;
    }
}