class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int n = s1.length();
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (flag) {
                freq1[s1.charAt(i) - 'a']++;
                freq1[s2.charAt(i) - 'a']--;
            }
            else {
                freq2[s1.charAt(i) - 'a']++;
                freq2[s2.charAt(i) - 'a']--;
            }

            flag = !flag;
        }

        for (int x : freq1) {
            if (x != 0) {
                return false;
            }
        }

        for (int x : freq2) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }
}