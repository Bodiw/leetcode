import java.util.Arrays;
import java.util.List;

public class L0386 {
    public static List<Integer> lexicalOrder(int n) {
        Integer[] list = new Integer[n];
        // 1 <= n <= 50000
        // n = 46367
        /*
         * Numbers to generate:
         * _1-9
         * __10-19
         * ___100-199
         * ____1000_1999
         * _____10000_19999
         * __20-29
         * ___200_299
         * ...
         */

        int idx = 0;
        int number = 1;

        while (idx < n) {
            list[idx] = number; // Store the last computed number
            if (number * 10 <= n) { // Iterates 1-10-100-1000-10000
                number *= 10;
            } else {
                if (number == n) // Special case for the reminder
                    number /= 10;
                number++; // Iterates through the numbers
                while (number % 10 == 0) // Remove zeroes
                    number /= 10;
            }
        }
        return Arrays.asList(list);
    }
}
