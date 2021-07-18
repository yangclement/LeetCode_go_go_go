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
    //in-order可以得到一个sorted的array，再用array做balanced的tree
    //可以优化的地方：别存node的val进入array，直接存node的pointer，就不用new新的treenode了，但是要和面试官make sure是否保持原有的tree
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedBST = new ArrayList<>();
        getSortedArray(root, sortedBST);
        TreeNode balanced = generateBST(sortedBST, 0, sortedBST.size() - 1);
        return balanced;
    }
    
    private TreeNode generateBST(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode curr = new TreeNode(nums.get(mid));
        curr.left = generateBST(nums, start, mid - 1);
        curr.right = generateBST(nums, mid + 1, end);
        return curr;
    }
    
    private void getSortedArray(TreeNode node, List<Integer> results) {
        if (node == null) {
            return;
        }
        getSortedArray(node.left, results);
        results.add(node.val);
        getSortedArray(node.right, results);
    }
}