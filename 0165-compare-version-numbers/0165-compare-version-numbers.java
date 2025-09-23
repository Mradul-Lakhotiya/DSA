class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();

        for (String str : version1.split("\\.")) {
            v1.add(Integer.valueOf(str));
        }

        for (String str : version2.split("\\.")) {
            v2.add(Integer.valueOf(str));
        }

        int n1 = v1.size();
        int n2 = v2.size();
        int n = Math.max(n1, n2);

        for (int i = 0; i < n; i++) {
            int num1 = (i < n1) ? v1.get(i) : 0;
            int num2 = (i < n2) ? v2.get(i) : 0;

            if (num1 > num2) {
                return 1;
            }
                
            if (num1 < num2) {
                return -1;
            } 
        }

        return 0;
    }
}