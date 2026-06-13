class Solution {
    public int distributeCandies(int n, int limit) {
        int res = 0;
        int[] temp = new int[]{n, 0, 0, 0};

        for (int i = 0; i <= Math.min(limit, n); i++) {
            temp[1] = temp[0] - i;
            for (int j = 0; j <= Math.min(limit, n); j++) {
                temp[2] = temp[1] - j;
                for (int k = 0; k <= Math.min(limit, n); k++) {
                    temp[3] = temp[2] - k;

                    if (temp[3] == 0) {
                        res++;
                    }
                }
            }

            temp[0] = n;
        }

        return res;
    }
}