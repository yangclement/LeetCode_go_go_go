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
    public int max;
    public int maxPathSum(TreeNode root) {
        //最开始思路：recusively traversal 这个tree，看看联通左右tree的话，是否能够更大
        //不能的话，把当前node加上左边或者加上右边，看看哪边大，然后返回给上一层
        if (root == null) {
            return 0;
        }
        max = Integer.MIN_VALUE;
        findSumRecurrsion(root);
        return max;
    }
    
    private int findSumRecurrsion(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        //一共有几总可能性对于当前的node？
        //左边加当前加上右边，当前自己，左边加自己，右边加自己，只有后三种需要return上去
        int left = findSumRecurrsion(curr.left);
        int right = findSumRecurrsion(curr.right);
        int result = Math.max(left + curr.val, right + curr.val);
        result = Math.max(result, curr.val);
        max = Math.max(max, result);
        max = Math.max(max, curr.val + left + right);
        return result;
        
    }
}