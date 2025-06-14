class Solution {
    public int minMaxDifference(int num) {
        String str = "" + num;
        int n = str.length();
        char[] chArr = str.toCharArray();
        char toNine = '9';
        char toZero = '0';
        StringBuilder maxNum = new StringBuilder();
        StringBuilder minNum = new StringBuilder();
        boolean toNineSet = false;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                toZero = chArr[i];
            }
            
            if (!toNineSet && chArr[i] != '9') {
                toNineSet = true;
                toNine = chArr[i];

                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (chArr[i] == toNine) {
                maxNum.append('9');
            }
            else {
                maxNum.append(chArr[i]);
            }

            if (chArr[i] == toZero) {
                minNum.append('0');
            }
            else {
                minNum.append(chArr[i]);
            }
        }

        return Integer.parseInt(maxNum.toString()) - Integer.parseInt(minNum.toString());
    }
}