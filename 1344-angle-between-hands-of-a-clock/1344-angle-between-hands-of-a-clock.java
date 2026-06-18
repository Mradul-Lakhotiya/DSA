class Solution {
    public double angleClock(int hour, int minutes) {
        double hrAng = 30 * hour + 0.5 * minutes;
        double minAng = 6 * minutes;

        return Math.min(360 - Math.abs(hrAng - minAng), Math.abs(minAng - hrAng));
    }
}