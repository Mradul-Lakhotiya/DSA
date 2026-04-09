class Solution {
    public String arrangeWords(String text) {
        String[] arr = text.split(" ");

        char[] c = arr[0].toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        arr[0] = new String(c);

        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });

        c = arr[0].toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        arr[0] = new String(c);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);

            if (i < arr.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }
}