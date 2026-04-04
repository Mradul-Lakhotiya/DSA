class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder[] arr = new StringBuilder[rows];
        int k = 0;

        for (int i = 0; i < rows; i++) {
            arr[i] = new StringBuilder(encodedText.substring(k, k + cols));
            k += cols;
        }

        StringBuilder res = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int i = 0;
            int j = startCol;

            while (i < rows && j < cols) {
                res.append(arr[i].charAt(j));
                i++;
                j++;
            }
        }

        while (res.length() > 0 && res.charAt(res.length() - 1) == ' ') {
            res.deleteCharAt(res.length() - 1);
        }

        return res.toString();
    }
}