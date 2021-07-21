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
    public int kthSmallest(TreeNode root, int k) {
        //但凡涉及k个最大或者最小的element基本上都是用heap，也就是pripority queue做
        //因为是smallest k就用inorder traversal，因为inorder是递增的
        //inorder 是有序的，无需要heap了，直接有个count看看当点k等不等与target k就好了
        //使用recursion的话就要用到global variable来记录count和results，不建议
        //这题使用iterator来做比较好
        //iterator的话就要用stack来记录路径了，详情可看BST iterator 那一题
        
        //先走到最左边开始
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        stack.push(curr);
        while (curr.left != null) {
            curr = curr.left;
            stack.push(curr);
        }
        int count = 0;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (++count == k) {
                return curr.val;
            }
            if (curr.right != null) {
                curr = curr.right;
                stack.push(curr);
                while (curr.left != null) {
                    curr = curr.left;
                    stack.push(curr);
                }
            }
        }
        return -1;
    }
}