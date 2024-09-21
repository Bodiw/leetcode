public class L3289 {
    public static int[] getSneakyNumbers(int[] nums) {
        boolean[] seen = new boolean[nums.length - 2];
        int[] answer = new int[2];
        int duplicates_seen = 0;

        for (int i : nums) {
            if (seen[i]) {
                answer[duplicates_seen++] = i;
                if (duplicates_seen == 2) {
                    return answer;
                }
            } else {
                seen[i] = true;
            }
        }
        return answer;
    }
}
