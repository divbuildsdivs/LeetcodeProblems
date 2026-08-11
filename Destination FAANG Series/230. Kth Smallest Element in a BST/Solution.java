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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedArray = addToArray(root, new ArrayList<>());
        return sortedArray.get(k-1);

        
    }
    public List<Integer> addToArray(TreeNode root, List<Integer> arr) {
         if(root == null) {
            return arr;
        }
        addToArray(root.left, arr);
        arr.add(root.val);
        addToArray(root.right, arr);
        return arr;
    }
}