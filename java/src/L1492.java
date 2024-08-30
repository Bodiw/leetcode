public class L1492 {
    public int kthFactor(int n, int k) {
        if (k == 1)
            return 1;

        int idx = 2;
        for (int i = 2; i <= n / 2; i++) {
            boolean isFactor = n % i == 0;
            if (isFactor && idx == k) {
                return i;
            } else if (isFactor) {
                idx++;
            }
        }

        if (idx == k)
            return n;

        return -1;
    }
}
