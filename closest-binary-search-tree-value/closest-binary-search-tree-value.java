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
    public int closestValue(TreeNode root, double target) {
        //使用while loop走 Node1 < target < Node2那一段即可
        //runtime是O(h);
        //solution的解法2，用stack储存之前的node，然后找一个node使得prev <= target < curr，然后根据diff return prev 还是curr
        int left = (int) target;
        int right = (int) Math.ceil(target);
        int result = 0;
        double min = Integer.MAX_VALUE;
        while (root != null) {
            //记录当前的diff
            if (Math.abs(target - root.val) < min) {
                min = Math.abs(target - root.val);
                result = root.val;
            }
            //如果target 大于当前值，往右走，因为忘左走数字越来越小，只会造成diff越来越大
            if (target > root.val) {
                root = root.right;
            } else {
                //如果小于或者等于，往左边走，理由同上
                root = root.left;
            }
        }
        return result;
    }

}