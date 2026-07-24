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
    public void flatten(TreeNode root) {
        flattenTree(root);
        
    }
    TreeNode flattenTree(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.right == null && root.left == null){
            return root;
        }
        TreeNode flattenedRight = flattenTree(root.right);
        TreeNode flattenedLeft = flattenTree(root.left);
        if(flattenedLeft != null) {
            flattenedLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return flattenedRight == null ? flattenedLeft : flattenedRight;
    }
}