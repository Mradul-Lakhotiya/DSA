class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank[0].length();
        int n = bank.length;
        int i = 0;
        int count1 = 0;
        int count2 = 0;
        int ans = 0;
        
        while (i < n) {
            for (int j = 0; j < m; j++) {
                if (bank[i].charAt(j) == '1') {
                    count2++;
                }
            }
            i++;

            if (count2 != 0) {
                ans += count1 * count2;
                count1 = count2;
                count2 = 0;
            }
        }

        return ans;
    }
}