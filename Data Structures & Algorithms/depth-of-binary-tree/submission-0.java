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
    public int maxDepth(TreeNode root) {
        return maxDepthT(root, 0);
    }

    private int maxDepthT(TreeNode root, int currentMax) {
        if (root == null) {
            return currentMax;
        }
        return Math.max(maxDepthT(root.left, currentMax + 1), maxDepthT(root.right, currentMax + 1));
    }
}
