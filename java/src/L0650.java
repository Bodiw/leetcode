import java.util.HashMap;
import java.util.Map;

public class L0650 {
    public int minSteps(int n) {
        int result = 0;

        HashMap<Integer, Integer> divisors = new HashMap<>();

        for (int divisor = 2; divisor <= Math.sqrt(n); divisor++) {
            int exponent = 0;

            while (n % divisor == 0) {
                n = n / divisor;
                exponent++;
            }

            if (exponent != 0)
                divisors.put(Integer.valueOf(divisor), Integer.valueOf(exponent));
        }
        if (n != 1)
            divisors.put(Integer.valueOf(n), Integer.valueOf(1));

        for (Map.Entry<Integer, Integer> e : divisors.entrySet())
            result += e.getValue() * e.getKey();

        return result;
    }
}
