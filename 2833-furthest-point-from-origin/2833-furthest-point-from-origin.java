class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int[] freq = new int[3];

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                freq[0]++;
            }
            else if (c == 'R') {
                freq[1]++;
            }
            else {
                freq[2]++;
            }
        }

        return Math.abs(freq[0] - freq[1]) + freq[2];
    }
}