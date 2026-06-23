class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        helper(0, s, new ArrayList<>());
        return res;
    }

    void helper(int i, String s, List<String> curr) {
        if (i == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);

            if (isPalindrome(sub)) {
                curr.add(sub);
                helper(j + 1, s, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}