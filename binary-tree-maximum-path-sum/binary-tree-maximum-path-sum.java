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
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findPath(root);
        return max;
    }
    
    private int findPath(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int left = findPath(curr.left);
        int right = findPath(curr.right);
        int results = Math.max(curr.val, Math.max(left + curr.val, right + curr.val));
        max = Math.max(max, results);
        max = Math.max(max, left + right + curr.val);

        return results;
    }
}