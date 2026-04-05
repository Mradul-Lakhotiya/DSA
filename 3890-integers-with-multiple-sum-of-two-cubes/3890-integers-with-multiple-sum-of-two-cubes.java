class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int limit = (int) Math.cbrt(n);

        for (int i = 1; i <= limit; i++) {
            int i3 = i * i * i;
            for (int j = i; j <= limit; j++) {
                int sum = i3 + j * j * j;

                if (sum > n) break;

                freq.put(sum, freq.getOrDefault(sum, 0) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int key : freq.keySet()) {
            if (freq.get(key) >= 2) {
                res.add(key);
            }
        }

        Collections.sort(res);

        return res;
    }
}