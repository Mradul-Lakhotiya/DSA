class Solution {
    public int maximumLength(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        int n = s.length();
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;
            char ch = s.charAt(i);

            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(len);

            i = j;
        }

        int ans = -1;

        for (List<Integer> list : map.values()) {
            list.sort(Collections.reverseOrder());

            while (list.size() < 3) {
                list.add(0);
            }

            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);

            ans = Math.max(ans, Math.max(
                    a - 2,
                    Math.max(Math.min(a - 1, b), c)
            ));
        }

        return ans <= 0 ? -1 : ans;
    }
}