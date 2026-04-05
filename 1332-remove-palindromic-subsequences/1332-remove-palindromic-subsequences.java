class Solution {
    public int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 : (isPalindrome(s) ? 1 : 2);
    }

    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}