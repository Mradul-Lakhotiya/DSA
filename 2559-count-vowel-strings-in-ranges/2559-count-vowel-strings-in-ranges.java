class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n1 = words.length;
        int n2 = queries.length;
        int[] helper = new int[n1 + 1];
        int[] ans = new int[n2];

        for (int i = 0; i < n1; i++) {
            String curr = words[i];

            helper[i + 1] = helper[i];

            if (isVowel(curr.charAt(0)) && isVowel(curr.charAt(curr.length() - 1))) {
                helper[i + 1]++;
            }
        }

        for (int i = 0; i < n2; i++) {
            ans[i] = helper[queries[i][1] + 1]  - helper[queries[i][0]];
        }

        return ans;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    } 
}