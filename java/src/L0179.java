import java.util.Arrays;
import java.util.Comparator;

public class L0179 {

    private static int number_of_digits(int n) {
        if (n < 100000) {
            if (n < 100) {
                if (n < 10) {
                    if (n == 0) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 2;
                }
            } else {
                if (n < 1000) {
                    return 3;
                } else {
                    if (n < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (n < 10000000) {
                if (n < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (n < 100000000) {
                    return 8;
                } else {
                    if (n < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    static long[] p10_lookup = new long[] { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000,
            1_000_000_000, 1_000_000_000 };

    public static String largestNumber(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (i2 == 0 || i1 == 0) {
                    return i1 - i2;
                }

                int d1 = number_of_digits(i1);
                int d2 = number_of_digits(i2);

                long tmp1 = p10_lookup[d2] * i1;
                long tmp2 = p10_lookup[d1] * i2;
                tmp1 += i2;
                tmp2 += i1;

                if (tmp2 == tmp1) { // Caso a=11 b=1
                    return d1 - d2;
                } else if (tmp2 > tmp1) {
                    return -1;
                } else {
                    return 1;
                }

            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0 || sb.length() > 0)
                sb.append(arr[i]);
        }
        if (sb.length() == 0)
            sb.append("0");
        return sb.toString();
    }

    public static void main(String[] args) {
        // largestNumber(new int[] { 10, 2 });
        largestNumber(new int[] { 1_000_000_000, 1_000_000_000 });
    }
}