class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = box[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            reverse(res[i]);
        }


        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (res[i][j] == '.') {
                    int temp = -1;

                    for (int k = i - 1; k >= 0; k--) {
                        if (res[k][j] == '*') {
                            break;
                        }

                        if (res[k][j] == '#') {
                            temp = k;
                            break;
                        }
                    }

                    if (temp != -1) {
                        res[temp][j] = '.';
                        res[i][j] = '#';
                    }
                }
            }
        }

        return res;
    }

    private void reverse(char[] row) {
        int l = 0;
        int r = row.length - 1;

        while (l < r) {
            char temp = row[l];
            row[l] = row[r];
            row[r] = temp;
            l++;
            r--;
        }
    }
}