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
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int preorderRootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        for(int i = 0; i< inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);


    }
    public TreeNode buildTree(int[] preorder, int inorderStart, int inorderEnd) {
        if(inorderEnd <  inorderStart || preorderRootIndex >= indexMap.size()) {
            return null;
        }
        int rootInorderIndex = indexMap.get(preorder[preorderRootIndex]);
        TreeNode root = new TreeNode(preorder[preorderRootIndex++]);
        root.left = buildTree(preorder, inorderStart, rootInorderIndex - 1 );
        root.right = buildTree(preorder, rootInorderIndex + 1, inorderEnd);
        return root;

    }
}