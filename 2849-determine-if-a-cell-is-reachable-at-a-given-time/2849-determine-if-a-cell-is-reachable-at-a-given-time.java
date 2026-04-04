class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int maxDis = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));

        if (maxDis == 0 && t == 1) {
            return false;
        }
        
        return t >= maxDis;
    }
}