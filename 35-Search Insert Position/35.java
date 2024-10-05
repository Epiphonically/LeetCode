import java.lang.Math;
class Solution {
    public int searchInsert(int[] nums, int target) {
        int curr = nums.length / 2;
        int prev = nums.length - 1;
        while (true) {
            if (nums[curr] == target) {
                return curr;
            } else if (nums[curr] > target) {
                prev = curr;
                curr = curr / 2;

            } else {
                if (curr + 1 == prev) {
                    curr = prev;
                } else {
                    curr += (prev - curr) / 2;
                }
                
            }
            if (curr == prev) {
               
                if (nums[curr] < target) {
                    return curr + 1;
                } else {
                    return curr;
                }
            }
        }
 
    }
}
