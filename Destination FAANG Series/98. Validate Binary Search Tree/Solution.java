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
        double rootMin = Double.NEGATIVE_INFINITY , rootMax = Double.POSITIVE_INFINITY;
        return checkValidNode(root, rootMin, rootMax);
        
    }

    boolean checkValidNode(TreeNode root, double minVal, double maxVal) {
       
        if(root == null ) {
            return true;
        }
         

        double rootVal = (double) root.val;
        boolean checkLeft = true;
        boolean checkRight = true;
        if(rootVal <= minVal || rootVal >= maxVal) {
            return false;
        }
        if(root.left != null) {
            checkLeft = checkValidNode(root.left, minVal, rootVal);
        }
        if(root.right != null) {
            checkRight = checkValidNode(root.right, rootVal, maxVal);
        }
        return checkLeft && checkRight;

    }

}