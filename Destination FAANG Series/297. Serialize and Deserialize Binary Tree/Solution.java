/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder serialized = new StringBuilder();
        serializeHelper(root, serialized);
        return serialized.toString().trim();
    }

    private void serializeHelper(TreeNode root, StringBuilder serialized) {
        if (root == null) {
            serialized.append("null ");
            return;
        }

        serialized.append(root.val).append(" ");

        serializeHelper(root.left, serialized);
        serializeHelper(root.right, serialized);
    }

    public TreeNode deserialize(String data) {
        String[] strArray = data.split("\\s+");
        List<String> strList = new ArrayList<>(Arrays.asList(strArray));

        return recdeserialize(strList);
    }

    private TreeNode recdeserialize(List<String> strList) {
        if (strList.get(0).equals("null")) {
            strList.remove(0);
            return null;
        }

        TreeNode node =
            new TreeNode(Integer.parseInt(strList.get(0)));

        strList.remove(0);

        node.left = recdeserialize(strList);
        node.right = recdeserialize(strList);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));