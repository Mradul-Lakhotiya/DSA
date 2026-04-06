class Solution {
    private static final int HASH_MULTIPLIER = 60001;

    public int robotSim(int[] cs, int[][] obstacles) {
        Set<Integer> set = new HashSet<>();

        for (int[] obstacle : obstacles) {
            set.add(hashCoordinates(obstacle[0], obstacle[1]));
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[] currPos = {0, 0};
        int max = 0;
        int currDir = 0;

        for (int c : cs) {
            if (c == -1) {
                currDir = (currDir + 1) % 4;
                continue; 
            }

            if (c == -2) {
                currDir = (currDir + 3) % 4;
                continue;
            }

            int[] direction = dir[currDir];

            for (int step = 0; step < c; step++) {
                int nextX = currPos[0] + direction[0];
                int nextY = currPos[1] + direction[1];

                if (set.contains(hashCoordinates(nextX, nextY))) {
                    break;
                }

                currPos[0] = nextX;
                currPos[1] = nextY;
            }

            max = Math.max(
                max,
                currPos[0] * currPos[0] +
                currPos[1] * currPos[1]
            );
        }

        return max;
    }

    private int hashCoordinates(int x, int y) {
        return x + HASH_MULTIPLIER * y;
    }
}