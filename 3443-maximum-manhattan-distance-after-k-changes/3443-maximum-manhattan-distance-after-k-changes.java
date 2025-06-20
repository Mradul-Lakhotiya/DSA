class Solution {
    public int maxDistance(String s, int k) {
        int x = 0;
        int y = 0;
        int n = s.length();
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            switch(ch) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
            }
            
            ans = Math.max(
                ans,
                Math.min(
                    Math.abs(x) + Math.abs(y) + k * 2,
                    i + 1
                )
            );
        }

        return ans;
    }
}