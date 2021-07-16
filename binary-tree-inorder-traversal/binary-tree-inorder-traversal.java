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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        
        inorderRecurrsion(root, results);
        return results;
    }
    private void inorderRecurrsion(TreeNode curr, List<Integer> results) {
        if (curr == null) {
            return;
        }
        inorderRecurrsion(curr.left, results);
        results.add(curr.val);
        inorderRecurrsion(curr.right, results);
    }
}