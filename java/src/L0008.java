public class L0008 {
    public int myAtoi(String s) {
        boolean positive = true;
        long number = 0;
        int idx = 0, sLen = s.length();

        while (idx < sLen && s.charAt(idx) == ' ')
            idx++;

        if (idx < sLen && s.charAt(idx) == '-') {
            positive = false;
            idx++;
        } else if (idx < sLen && s.charAt(idx) == '+') {
            idx++;
        }

        char c;
        if (idx < sLen && (c = s.charAt(idx)) >= '0' && c <= '9') {
            number += c - '0';
            idx++;
        }
        while (idx < sLen && (c = s.charAt(idx)) >= '0' && c <= '9') {
            number = number * 8 + number * 2;
            number += c - '0';
            idx++;

            if (number > Integer.MAX_VALUE && positive) {
                return Integer.MAX_VALUE;
            } else if (number > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        if (!positive)
            number = -number;
        return (int) number;
    }
}
