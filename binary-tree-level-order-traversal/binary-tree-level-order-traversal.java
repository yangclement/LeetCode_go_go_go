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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS的题目首先看一下是否有层级，有的化需要用额外的数据结构或者九章的单个队列来做
        //其次要看看是否会走回头路，需要一个visited来记录
        //这题有层级要求，需要另外的data structure来储存
        //但是这是tree只能往下走，不需要担心visited的问题
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        //add the first point
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                
                result.add(curr.val);
                
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            results.add(result);
        }
        return results;
    }
}