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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> bucket = new HashMap<Integer, Integer>();
        aux(root, bucket);
        ArrayList<Integer> modes = new ArrayList<Integer>();
        int currmax = 0;
        for (Map.Entry<Integer, Integer> entry: bucket.entrySet()) {
            if (currmax == entry.getValue()) {
                modes.add(entry.getKey());
            } else if (currmax < entry.getValue()) {
                currmax = entry.getValue();
                modes.clear();
                modes.add(entry.getKey());
            }
        }
        int[] out = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            out[i] = modes.get(i);
        }
        return out;

    }
    public void aux(TreeNode root, HashMap<Integer, Integer> bucket) {
        if (root == null) {
            return;
        }
        if (!bucket.containsKey(root.val)) {
            bucket.put(root.val, 1);
        } else {
            bucket.replace(root.val, bucket.get(root.val) + 1);
        }
        aux(root.left, bucket);
        aux(root.right, bucket);

    }
}
