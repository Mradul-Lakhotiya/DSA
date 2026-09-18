class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        boolean[] taken = new boolean[26];
        int[][] index = new int[26][3];

        for (int i = 0; i < 26; i++) {
            index[i][2] = i;
        }

        for (int i = 0; i < n; i++) {
            if (!taken[s.charAt(i) - 'a']) {
                index[s.charAt(i) - 'a'][0] = i;
                taken[s.charAt(i) - 'a'] = true; 
            }

            index[s.charAt(i) - 'a'][1] = i;
        }

        for (int[] interval : index) {
            if (!taken[interval[2]]) {
                continue;
            }

            int start = interval[0];
            int end = interval[1];
            boolean isValid = true;

            for (int i = start; i <= end; i++) {
                int ch = s.charAt(i) - 'a';

                for (int j = 0; j < 26; j++) {
                    if (index[j][2] == ch) {
                        if (index[j][0] < start) {
                            isValid = false;
                            break;
                        }

                        end = Math.max(end, index[j][1]);
                        break;
                    }
                }

                if (!isValid) {
                    break;
                }
            }
            
            if (!isValid) {
                taken[interval[2]] = false;
            }
            else {
                interval[1] = end;
            }
        }

        Arrays.sort(index, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        List<String> res = new ArrayList<>();
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : index) {
            int c = interval[2];

            if (!taken[c]) {
                continue;
            }

            int start = interval[0];
            int end = interval[1];

            if (start > lastEnd) {
                res.add(s.substring(start, end + 1));
                lastEnd = end;
            }
        }

        return res;
    }
}