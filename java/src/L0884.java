import java.util.HashSet;

public class L0884 {
    public static String[] uncommonFromSentences(String s1, String s2) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> duplicated_words = new HashSet<>();

        for (String sentence : new String[] { s1, s2 }) {
            for (String word : sentence.split(" ")) {
                if (set.contains(word) || duplicated_words.contains(word)) {
                    duplicated_words.add(word);
                    set.remove(word);
                } else {
                    set.add(word);
                }
            }
        }

        return set.toArray(new String[set.size()]);
    }
}
