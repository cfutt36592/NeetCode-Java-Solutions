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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, - Double.MAX_VALUE, Double.MAX_VALUE);
    }
    
    public boolean isValid(TreeNode root, double min, double max){
        if(root == null) return true;
        
        if(root.val <= min || root.val >= max) return false;
        
        if(isValid(root.left, min, root.val) && isValid(root.right, root.val, max)) return true;
        return false;
    }
    
}
