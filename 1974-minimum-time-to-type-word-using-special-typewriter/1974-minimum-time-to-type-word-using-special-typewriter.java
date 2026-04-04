class Solution {
    public int minTimeToType(String word) {
        int res = 0;
        char temp = 'a';

        for (char c : word.toCharArray()) {
            res += Math.min(Math.abs(temp - c), 26 - Math.abs(temp - c));
            temp = c;
            res++;
        }

        return res;
    }
}