class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isPrefixAndSuffix(words[i], words[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        if (n1 > n2) {
            return false;
        }

        for (int i = 0; i < n1; i++) {

            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }

            if (str1.charAt(n1 - 1 - i) != str2.charAt(n2 - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}