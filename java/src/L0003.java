public class L0003 {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start_idx = 0;
        int end_idx = 0;
        int length = 0;
        int s_len = s.length();
        short[] last_char_pos = new short[256];

        for (int i = 0; i < last_char_pos.length; i++)
            last_char_pos[i] = -1;

        while (end_idx < s_len) {
            char c = s.charAt(end_idx);
            int last_c_index = last_char_pos[c];
            if (last_c_index != -1) {
                length = end_idx - start_idx;
                if (length > max)
                    max = length;

                for (int i = start_idx; i < last_c_index; i++)
                    last_char_pos[s.charAt(i)] = -1;

                start_idx = last_c_index + 1;
            }
            last_char_pos[c] = (short) end_idx;
            end_idx++;
        }

        length = end_idx - start_idx;
        if (length > max)
            max = length;

        return max;
    }
}
