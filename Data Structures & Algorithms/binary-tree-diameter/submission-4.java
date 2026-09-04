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
    static int result = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        helper(root);
        return result;
    }
    public int helper(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        result = Math.max(result, left + right);
        return Math.max(left, right);
    }
}
