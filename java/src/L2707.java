import java.util.List;
import java.util.ArrayList;

public class L2707 {
    static class TrieNode {
        boolean is_word;
        TrieNode[] children;

        TrieNode() {
            this.children = new TrieNode[27];
        }

        public void add_word(String s) {
            TrieNode node = this;
            TrieNode child = null;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                child = node.children[c - 'a'];
                if (child != null) {
                    node = child;
                } else {
                    child = new TrieNode();
                    node.children[c - 'a'] = child;
                    node = child;
                }
            }
            child.is_word = true;
        }

        public List<Integer> prefixes(char[] arr, int start_idx, int end_idx) {
            List<Integer> list = new ArrayList<>();

            TrieNode node = this;
            for (int i = start_idx; i < end_idx; i++) {
                char c = arr[i];
                node = node.children[c - 'a'];
                if (node == null)
                    break;

                if (node.is_word)
                    list.add(i - start_idx + 1);
            }
            return list;
        }

    }

    public static int minExtraChar(String s, String[] dictionary) {
        int s_len = s.length();
        int[] dp = new int[s_len + 1];
        TrieNode trie = new TrieNode();
        char[] s_arr = s.toCharArray();
        for (String word : dictionary)
            trie.add_word(word);
        // Actual program I guess
        for (int idx = 1; idx <= s_len; idx++) {
            List<Integer> prefixes = trie.prefixes(s_arr, idx - 1, s_len);

            for (Integer p_len : prefixes) {
                dp[idx + p_len - 1] = Math.max(dp[idx + p_len - 1], dp[idx - 1] + p_len);
            }

            dp[idx] = Math.max(dp[idx], dp[idx - 1]);
        }

        return s_len - dp[s_len];
    }
}