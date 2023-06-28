class Solution {
    public static int romanToInt(String s) {
        String romans = "IVXLCDM";
        int[] values = { 1, 5, 10, 50, 100, 500, 1000 };
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int nextVal = i + 1 != s.length() ? values[romans.indexOf(s.charAt(i + 1))] : 0;
            int val = values[romans.indexOf(s.charAt(i))];
            sum += val * (val < nextVal ? -1 : 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] s = { "III", "LVIII", "MCMXCIV" };
        int[] res = { 3, 58, 1994 };

        for (int i = 0; i < s.length; i++) {
            System.out.println(String.format("%10s = %5d | %5d", s[i], romanToInt(s[i]), res[i]));
        }
    }
}