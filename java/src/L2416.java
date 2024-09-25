public class L2416 {
    static class TrieNode {
        int score;
        TrieNode[] children;

        TrieNode() {
            this.score = 0;
            this.children = new TrieNode[27];
        }

        TrieNode(int score) {
            this.score = score;
            this.children = new TrieNode[27];
        }

        public void add_word(String s) {
            TrieNode node = this;
            TrieNode child = null;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                child = node.children[c - 'a'];
                if (child != null) {
                    child.score++;
                    node = child;
                } else {
                    child = new TrieNode(1);
                    node.children[c - 'a'] = child;
                    node = child;
                }
            }
        }

        public int get_score(String prefix) {
            TrieNode node = this;
            TrieNode child = null;
            int sum = 0;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                child = node.children[c - 'a'];
                sum += child.score;
                node = child;
            }
            return sum;
        }
    }

    public static int[] sumPrefixScores(String[] words) {
        TrieNode trie = new TrieNode();
        for (String s : words)
            trie.add_word(s);

        int[] scores = new int[words.length];
        for (int i = 0; i < scores.length; i++)
            scores[i] = trie.get_score(words[i]);

        return scores;
    }
}
