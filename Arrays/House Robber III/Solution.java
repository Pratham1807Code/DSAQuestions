/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public int rob(TreeNode root) {
        // Returns maximum value from the pair: [includeRoot, excludeRoot]
        int[] result = heist(root);
        return Math.max(result[0], result[1]);
    }

    private int[] heist(TreeNode root) {
        // Empty tree case
        if (root == null) {
            return new int[] { 0, 0 };
        }

        // Recursively calculating the maximum amount that can be robbed from the left
        // subtree of the root
        int[] leftSubtree = heist(root.left);

        // Recursively calculating the maximum amount that can be robbed from the right
        // subtree of the root
        int[] rightSubtree = heist(root.right);

        // includeRoot contains the maximum amount of money that can be robbed with the
        // parent node included
        int includeRoot = root.val + leftSubtree[1] + rightSubtree[1];

        // excludeRoot contains the maximum amount of money that can be robbed with the
        // parent node excluded
        int excludeRoot = Math.max(leftSubtree[0], leftSubtree[1]) + Math.max(rightSubtree[0], rightSubtree[1]);

        return new int[] { includeRoot, excludeRoot };
    }
}