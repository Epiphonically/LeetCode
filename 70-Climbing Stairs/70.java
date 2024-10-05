class Solution {
    public int climbStairs(int n) {
        int found[] = new int[n + 1];
        found[1] = 1;
        if (n >= 2) {
            found[2] = 2;
        }
        
        for (int i = 3; i <= n; i++) {
            found[i] = found[i - 1] + found[i - 2];
        }
        return found[n];
    }
}
