class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        int i = digits.length - 1;
        while (i - 1 >= 0 && digits[i] <= digits[i - 1]) {
            i--;
        }

        if (i == 0) {
            return -1;
        }

        int j = i;
        while (j + 1 < digits.length && digits[j + 1] > digits[i - 1]) {
            j++;
        }

        char temp = digits[i - 1];
        digits[i - 1] = digits[j];
        digits[j] = temp;

        reverse(digits, i, digits.length - 1);

        long res = Long.parseLong(new String(digits));

        return res < (1L << 31) ? (int) res : -1;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}