class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;
        boolean center = false;

        for (String word : words) {
            String rev = reverse(word);

            if (map.getOrDefault(rev, 0) > 0) {
                count += 4;

                map.put(rev, map.get(rev) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (isSame(key) && map.get(key) > 0) {
                center = true;
                break;
            }
        }

        if (center) {
            count += 2;
        }

        return count;
    }

    boolean isSame(String s) {
        return s.charAt(0) == s.charAt(1);
    }

    String reverse(String s) {
        return "" + s.charAt(1) + s.charAt(0);
    }
}