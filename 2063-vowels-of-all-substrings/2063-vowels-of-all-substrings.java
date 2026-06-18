class Solution {
    public long countVowels(String word) {
        char[] ch = word.toCharArray();
        int n = ch.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (ch[i] == 'a' || ch[i] == 'e' || 
                ch[i] == 'i' || ch[i] == 'o' || 
                ch[i] == 'u') {
                
                sum += (long)(i + 1) * (n - i);
            }
        }

        return sum;
    }
}