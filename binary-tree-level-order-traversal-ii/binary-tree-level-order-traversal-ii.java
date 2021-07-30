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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //思路：和这道题的I 基本上一样，不过这次results用linkedlist，每一层的结果加在linkedlist的头部就好
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                result.add(curr.val);
            }
            //因为是用的是interface的list，没有addfirst，但是可以用下面add的方法把element add到第一个位置
            results.add(0, result);
        }
        return results;
    }
    
    //这个可以是dfs recurrsion的解法，用一个k来记录当前的level，然后根据level找到list里面相对应的index再加进去
    // private int traversalRecurrsive(List<List<Integer>> results, TreeNode curr) {
    //     if (curr == null) {
    //         return 0;
    //     }
    //     traversalRecurrsive(results, curr.left);
    //     traversalRecurrsive(results, curr.right);
    // }
}