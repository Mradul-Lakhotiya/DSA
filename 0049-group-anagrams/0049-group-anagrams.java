public class Solution {
    class Key {
        int[] freq;

        Key(String s) {
            freq = new int[26];

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Key o = (Key) obj;

            for (int i = 0; i < 26; i++) {
                if (this.freq[i] != o.freq[i]) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(freq);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> fans = new ArrayList<>();
        Map<Key, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            Key freq = new Key(strs[i]);

            if (map.containsKey(freq)) {
                map.get(freq).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(freq, list);
            }
        }

        fans.addAll(map.values());

        return fans;
    }
}