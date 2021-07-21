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
    public List<String> binaryTreePaths(TreeNode root) {
        //path类型是backtraking，因为走完左子树要去掉左子树的状态，右子树同理
        List<String> results = new ArrayList<String>();
        if (root == null) {
            return results;
        }
        findPathRecurrsion(root, results, "");
        return results;
    }
    private void findPathRecurrsion(TreeNode curr, List<String> results, String path) {
        //在leaf节点就处理了，不要去到curr == null 再处理，不好控制
        if (curr.left == null && curr.right == null) {
            results.add(path + curr.val);
            return;
        }
        //下面的path + curr.val + "->"因为每次都新new 一个 String，十分的浪费空间，
        //如果面试官要求，可以先把所有node val加进去list of integer，然后出来之后再用while loop慢慢append
        if (curr.left != null) {
            findPathRecurrsion(curr.left, results, path + curr.val + "->");
        }
        if (curr.right != null) {
            findPathRecurrsion(curr.right, results, path + curr.val + "->");
        }
    }
}