class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String q : queries) {
            for (String s : dictionary) {
                int dis = 0;

                for (int i = 0; i < q.length(); i++) {
                    if (q.charAt(i) != s.charAt(i)) {
                        dis++;
                    } 
                }

                if (dis <= 2) {
                    ans.add(q);
                    break;
                }
            }
        }

        return ans;
    }
}