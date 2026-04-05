class Solution {
    public boolean judgeCircle(String moves) {   
        int[] pos = new int[2];

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                pos[0]++;
            }
            else if (c == 'D') {
                pos[0]--;
            }
            else if (c == 'R') {
                pos[1]++;
            }
            else {
                pos[1]--;
            }
        }

        return (pos[0] == 0 && pos[1] == 0);
    }
}