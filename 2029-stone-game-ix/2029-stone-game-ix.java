class Solution {
    public boolean stoneGameIX(int[] stones) {
        int z = 0, o = 0, t = 0;

        for (int x : stones) {
            int ty = x % 3;

            if (ty == 0) {
                z++;
            }
            else if (ty == 1) {
                o++;
            }
            else {
                t++;
            }
        }

        if (z % 2 == 0) {
            return o >= 1 && t >= 1;
        }

        return o - t > 2 || t - o > 2;
    }
}