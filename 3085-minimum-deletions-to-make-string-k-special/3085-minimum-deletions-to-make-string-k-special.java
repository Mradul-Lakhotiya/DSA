class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        
        for (char ch : word.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int res = word.length();

        for (int a : freq.values()) {
            int del = 0;

            for (int b : freq.values()) {
                if (a > b) {
                    del += b;
                }
                else if (b > a + k) {
                    del += b - (a + k);
                }
            }

            res = Math.min(res, del);
        }

        return res;
    }
}