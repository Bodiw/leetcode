import java.util.HashMap;

public class L0001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            Integer num1 = nums[i];
            Integer num2 = target - num1;
            Integer idx1 = Integer.valueOf(i);
            Integer idx2 = map.get(num2);
            if (idx2 != null) {
                return new int[] { idx1, idx2 };
            } else {
                map.put(Integer.valueOf(num1), Integer.valueOf(i));
            }

        }
        return null;
    }
}
