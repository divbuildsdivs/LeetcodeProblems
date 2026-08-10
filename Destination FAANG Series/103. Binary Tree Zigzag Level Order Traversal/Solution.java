
class Solution {
    List<List<Integer>> listOfList = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) {
            addToList(root, 0);
            for(int i =0 ; i< listOfList.size(); i++) {
                ArrayList<Integer> nums= new ArrayList<>();
                if(i%2 == 0) {
                    for(int j = 0; j<listOfList.get(i).size(); j++) {
                        nums.add(listOfList.get(i).get(j));
                    }
                }
                else {
                    for(int j = listOfList.get(i).size() - 1 ; j >= 0; j--) {
                        nums.add(listOfList.get(i).get(j));
                    }
                }
                result.add(nums);
            }
        }
            
        
        return result;
        
    }
    public void addToList(TreeNode root, int level) {
        if(listOfList.size() - 1 >= level) {
            listOfList.get(level).add(root.val);
        }
        else {
            ArrayList<Integer> numList= new ArrayList<>();
            numList.add(root.val);
            listOfList.add(numList); 
        }
    
        if(root.left != null)
            addToList(root.left, level + 1);
        if(root.right != null)
            addToList(root.right, level + 1);
    }
}