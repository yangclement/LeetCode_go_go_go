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
public class TreeInfo{
    int height;
    boolean balanced;
    TreeInfo(int h, boolean balanced) {
        this.height = h;
        this.balanced = balanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        //首先对于每个node来说，不仅要先判断左子树和右子树的height是否相差1，还要分别判断左子树和右子树本身是不是balanced的 
        //所以对于recursion的function我们希望return isbalanced 和 height两个variable
        //只有python支持return 多个value，在java里面如果想要return多个vatiable，必须要define一个新的 class
        if (root == null) {
            return true;
        }
        TreeInfo results = findSubTree(root);
        return results.balanced;
    }
    
    private TreeInfo findSubTree(TreeNode curr) {
        if (curr == null) {
            return new TreeInfo(0, true);
        }
        TreeInfo left = findSubTree(curr.left);
        TreeInfo right = findSubTree(curr.right);
        if (!left.balanced || !right.balanced) {
            return new TreeInfo(0, false);
        }
        int diff = Math.abs(left.height - right.height);
        if (diff > 1) {
            return new TreeInfo(0, false);
        }
        return new TreeInfo(Math.max(left.height, right.height) + 1, true);
    }
}