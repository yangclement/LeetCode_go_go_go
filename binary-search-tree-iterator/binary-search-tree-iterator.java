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
        //改进了两次找最左边的node，可以refactor成helper function
        this.stack = new Stack<TreeNode>();
        findMostLeft(root);
        // while (root != null) {
        //     this.stack.push(root);
        //     root = root.left;
        // }
    }
    
    public int next() {
        //这里和jiuzhang的做法不一样，jiuzhang是peek，不拿出来，但此时这个peek的点已经visited了，应该是要拿出来的，jiuzhang的做法可能是模版，可以做其他的bst
        //所以当right为null的时候，就要去找第一个通过左子树拐进来的node
        //如果直接pop出来的话，当right为null，stack里面的下一个就必定是第一个通过左子树拐进来的点了。因为看过的点都pop了，没看过的根据inorder左中右就必定是第一个通过左子树拐进来的点
        //复习的时候如果不懂可以看一下jiuzhang解法和视频
        TreeNode curr = this.stack.pop();
        if (curr.right != null) {
            findMostLeft(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !this.stack.empty();
    }
    
    private void findMostLeft(TreeNode node) {
        while (node != null) {
            this.stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */