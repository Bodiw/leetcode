public class L0005 {
    public String longestPalindrome(String s) {
        int maxLen = 1;
        int idx = 0;
        // Case for UnEven
        for (int i = 0; i < s.length(); i++) {
            int radius = 1;
            while (i - radius >= 0 && i + radius < s.length() &&
                    s.charAt(i - radius) == s.charAt(i + radius))
                radius++;
            int newLen = 2 * (radius - 1) + 1;
            if (newLen > maxLen) {
                maxLen = newLen;
                idx = i - radius + 1;
            }
        }

        // Case for Even
        for (int i = 0; i < s.length(); i++) {
            int radius = 1;
            while (i - radius + 1 >= 0 && i + radius < s.length() &&
                    s.charAt(i - radius + 1) == s.charAt(i + radius))
                radius++;
            int newLen = 2 * (radius - 1);
            if (newLen > maxLen) {
                maxLen = newLen;
                idx = i - (radius - 2);
            }
        }
        return s.substring(idx, idx + maxLen);
    }
}
