class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }

        StringBuilder sb = new StringBuilder(s);

        while (true) {
            int i = sb.indexOf("(");
            int j = sb.indexOf(")");

            if (i == -1) {
                break;
            }

            sb.replace(i, j + 1, map.getOrDefault(sb.substring(i + 1, j), "?")); 
        }

        return sb.toString();
    }
}