        class Solution {
            public String generateString(String str1, String str2) {
                int n = str1.length();
                int m = str2.length();
                int L = n + m - 1;

                char[] res = new char[L];
                int[] fix = new int[L];
                Arrays.fill(res, 'a');

                for (int i = 0; i < n; i++) {
                    if (str1.charAt(i) == 'T') {
                        for (int j = 0; j < m; j++) {
                            if (fix[i + j] == 1 && res[i + j] != str2.charAt(j)) {
                                return "";
                            }
                            res[i + j] = str2.charAt(j);
                            fix[i + j] = 1;
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (str1.charAt(i) == 'F') {
                        boolean flag = false;
                        int idx = -1;

                        for (int j = m - 1; j >= 0; j--) {
                            if (res[i + j] != str2.charAt(j)) {
                                flag = true;
                            }
                            if (idx == -1 && fix[i + j] == 0) {
                                idx = j;
                            }
                        }

                        if (flag) {
                            continue;
                        }
                        else if (idx != -1) {
                            res[i + idx] = 'b';
                        }
                        else {
                            return "";
                        }
                    }
                } 

                return new String(res);
            }
        }