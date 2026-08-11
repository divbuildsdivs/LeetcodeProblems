/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int maxVal = Math.max(p.val, q.val);
        int minVal = Math.min(p.val,q.val);
        int rootVal = root.val;
        if(root.val >= minVal && root.val <= maxVal) {
            return root;
        }
        return (root.val < minVal) ? lowestCommonAncestor(root.right, p, q): lowestCommonAncestor(root.left, p, q);
        
    }
}