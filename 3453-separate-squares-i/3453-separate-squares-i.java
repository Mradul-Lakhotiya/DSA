class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = getAreaBelowLine(squares, Double.MAX_VALUE);
        double toGet = totalArea / 2;
        double l = Double.MAX_VALUE;
        double r = Double.MIN_VALUE;
        double eps = 1e-5;

        while (Math.abs(l - r) > eps) {
            double m = (l + r) / 2;
            double midArea = getAreaBelowLine(squares, m);

            if (toGet > midArea) {
                r = m;
            }
            else {
                l = m;
            }
        }

        return l;
    }

    private static double getAreaBelowLine(int[][] squares, double y) {
        double area = 0;

        for (int[] square : squares) {
            int y0 = square[1];
            int L = square[2];

            if (y0 >= y) {
                continue;
            }

            double H = Math.min(y - y0, L);
            area += L * H;
        }

        return area;
    }
}