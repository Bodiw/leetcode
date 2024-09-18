public class L1310 {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] cache = new int[arr.length];

        cache[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cache[i] = cache[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == query[1])
                result[i] = arr[query[0]];
            else
                result[i] = cache[query[1]] ^ (query[0] == 0 ? 0 : cache[query[0] - 1]);
        }
        return result;
    }
}
