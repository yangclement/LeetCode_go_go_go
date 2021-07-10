
  public class TreeNode {
      int val;
      int max;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    //input constrain? all positive? all number? null? 
    public int goodNodes(TreeNode root) {
        //remember the maximun value from the root to the current node.
        if(root==null){
            return 0;
        }
        else{
            return nodesFinder(root.val, root.left) + nodesFinder(root.val, root.right) + 1;
        }
    }
    
    //this max is from the previous node
    private int nodesFinder(int max, TreeNode root){
        if(root == null){
            return 0;
        }
        int numOfMax = 0;
        if(root.val >= max){
            root.max = root.val;
            numOfMax ++;
        } else {
            root.max = max;
        }
        numOfMax += nodesFinder(root.max, root.left);
        numOfMax += nodesFinder(root.max, root.right);
        return numOfMax;
        
        
    }
}