public class L0214 {
    public static String shortestPalindrome(String s) {
        char[] str = new StringBuilder(s)
                .append("$")
                .append(new StringBuilder(s).reverse())
                .toString()
                .toCharArray();
        int[] fail_table = new int[str.length];

        for (int str_idx = 1, pattern_idx = 0; str_idx < str.length;) {
            if (str[str_idx] == str[pattern_idx]) {
                pattern_idx++;
                fail_table[str_idx] = pattern_idx;
                str_idx++;
            } else {
                if (pattern_idx > 0) {
                    pattern_idx = fail_table[pattern_idx - 1];
                } else {
                    fail_table[str_idx] = 0;
                    str_idx++;
                }
            }
        }

        return new StringBuilder(s.substring(fail_table[str.length - 1]))
                .reverse()
                .append(s)
                .toString();
    }
}
