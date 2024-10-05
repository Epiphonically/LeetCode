class Solution {
    public boolean isPowerOfFour(int n) {
        int start = 1;
        for (int i = 0; i < Math.sqrt(n); i++) {
            if (start == n) {
                return true;
                
            }
            start *= 4;
        }
        return false;
    }
}
