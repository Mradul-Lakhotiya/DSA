class TrieNode {
    TrieNode[] ch = new TrieNode[26];
    int minLen = Integer.MAX_VALUE;
    int idx = -1;

    TrieNode() {
        for (int i = 0; i < 26; i++) {
            ch[i] = null;
        }
    }
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String s, int i) {
        int len = s.length();
        TrieNode node = root;

        if (len < node.minLen) {
            node.minLen = len;
            node.idx = i;
        }

        for (char cha : s.toCharArray()) {
            int c = cha - 'a';
            if (node.ch[c] == null) {
                node.ch[c] = new TrieNode();
            }

            node = node.ch[c];

            if (len < node.minLen) {
                node.minLen = len;
                node.idx = i;
            }
        }
    }

    int query(String s) {
        TrieNode node = root;

        for (char cha : s.toCharArray()) {
            int c = cha - 'a';

            if (node.ch[c] != null) {
                node = node.ch[c];
            }
            else {
                break;
            }
        }

        return node.idx;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie t = new Trie();
        int n = wordsContainer.length;
        int m = wordsQuery.length;

        for (int i = 0; i < n; i++) {
            t.insert(new StringBuilder(wordsContainer[i]).reverse().toString(), i);
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = t.query(new StringBuilder(wordsQuery[i]).reverse().toString());
        }

        return res;
    }
}