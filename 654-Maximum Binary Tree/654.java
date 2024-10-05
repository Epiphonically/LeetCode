/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int currMax = 0;
        int currMaxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > currMax) {
                currMax = nums[i];
                currMaxIndex = i;
            }
        }
        TreeNode output = new TreeNode(currMax);
        int[] rightArray = new int[nums.length - currMaxIndex - 1];
        int index = 0;
        for (int i = currMaxIndex + 1; i < nums.length; i++) {
            rightArray[index++] = nums[i];
        }
        int[] leftArray = new int[currMaxIndex];
        index = 0;
        for (int i = 0; i < currMaxIndex; i++) {
            leftArray[index++] = nums[i];
        }
        if (leftArray.length == 0) {
            output.left = null;
        } else {
            output.left = constructMaximumBinaryTree(leftArray);
        }
        if (rightArray.length == 0) {
            output.right = null;
        } else {
            output.right = constructMaximumBinaryTree(rightArray);
        }
        
        return output;
    }
}
