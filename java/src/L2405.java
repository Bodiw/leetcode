import java.util.Arrays;

public class L2405 {
    public int partitionString(String s) {
        int partitions = 1;
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (seen[idx]) {
                Arrays.fill(seen, false);
                partitions++;
            }
            seen[idx] = true;
        }
        return partitions;
    }
}
