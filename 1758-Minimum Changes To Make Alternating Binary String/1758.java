class Solution {
    public int minOperations(String s) {
        int zero_start = 0;
        int one_start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    zero_start++;
                } else {
                    one_start++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    one_start++;
                } else {
                    zero_start++;
                }
            }
        }
        return (zero_start <= one_start ? zero_start : one_start);
    }
}
