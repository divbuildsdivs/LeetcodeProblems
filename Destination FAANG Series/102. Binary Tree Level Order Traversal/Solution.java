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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root != null)
            addToList(root, 0);
        return result;
        
    }
    public void addToList(TreeNode root, int level) {
        if(result.size() - 1 >= level) {
            result.get(level).add(root.val);
        }
        else {
            ArrayList<Integer> numList= new ArrayList<>();
            numList.add(root.val);
            result.add(numList); 
        }
    
        if(root.left != null)
            addToList(root.left, level + 1);
        if(root.right != null)
            addToList(root.right, level + 1);
    }
}