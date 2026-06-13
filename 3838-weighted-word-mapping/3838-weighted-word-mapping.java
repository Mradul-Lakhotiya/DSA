class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();

        for (String s : words) {
            int sum = 0;

            for (char c : s.toCharArray()) {
              sum += weights[c - 'a'];
            }

            int rem = sum % 26;
            res.append((char)('z' - rem));
        }

        return res.toString();
    }
}  