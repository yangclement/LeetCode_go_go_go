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
class BSTIterator {
    
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        //initilize the 时候就直接去到最左边的treenode， 因为要从那个node开始
        this.stack = new Stack<TreeNode>();
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode curr = this.stack.pop();
        TreeNode node = curr;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                this.stack.push(node);
                node = node.left;
            }
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !this.stack.empty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */