class TrieNode {
    TrieNode[] childern = new TrieNode[10];
}

class Trie {

    TrieNode root = new TrieNode();

    void insert(int num) {
        TrieNode node = root;
        String numStr = Integer.toString(num);

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';

            if (node.childern[idx] == null) {
                node.childern[idx] = new TrieNode();
            }

            node = node.childern[idx];
        }
    }

    int findLongestPrefix(int num) {
        TrieNode node = root;
        String numStr = Integer.toString(num);
        int len = 0;

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';

            if (node.childern[idx] != null) {
                len++;
                node = node.childern[idx];
            }
            else {
                break;
            }
        }

        return len;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        for (int num : arr1) {
            trie.insert(num);
        }

        int ans = 0;

        for (int num : arr2) {
            ans = Math.max(ans, trie.findLongestPrefix(num));
        }

        return ans;
    }
}