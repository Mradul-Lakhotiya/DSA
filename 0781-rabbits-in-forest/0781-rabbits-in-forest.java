class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : answers) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int x = entry.getKey();
            int cnt = entry.getValue();

            int size = x + 1;
            int groups = (cnt + size - 1) / size;

            ans += groups * size;
        }

        return ans;
    }
}