class Solution {
    public String convertToTitle(int cNum) {
        StringBuilder sb = new StringBuilder();

        while (cNum > 0) {
            cNum--;
            sb.append((char)('A' + (cNum % 26)));
            cNum = cNum / 26;
        }

        return sb.reverse().toString();
    }
}