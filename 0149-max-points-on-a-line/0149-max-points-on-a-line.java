class Solution {

    class Pair {
        int dx;
        int dy;

        Pair(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            Pair p = (Pair) obj;

            return dx == p.dx && dy == p.dy;
        }

        @Override
        public int hashCode() {
            return 31 * dx + dy;
        }
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 0;

        if (n <= 2) {
            return n;
        }

        for (int i = 0; i < n; i++) {
            HashMap<Pair, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(dx, dy);

                dx /= g;
                dy /= g;

                if (dx == 0) {
                    dy = 1;
                } 
                else if (dy == 0) {
                    dx = 1;
                } 
                else if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                Pair key = new Pair(dx, dy);
                map.put(key, map.getOrDefault(key, 0) + 1);
                ans = Math.max(ans, map.get(key) + 1);
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}