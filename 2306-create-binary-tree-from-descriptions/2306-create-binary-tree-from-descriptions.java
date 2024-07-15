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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<TreeNode, Boolean> isChild = new HashMap<>();
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        for(int i[]: descriptions){
            TreeNode parent = null;
            if(nodes.containsKey(i[0]))
                parent = nodes.get(i[0]);
            else {
                parent = new TreeNode(i[0]);
                nodes.put(i[0], parent);
            }

            if(!isChild.containsKey(parent))
                isChild.put(parent, false);

            TreeNode child = null;
            if(nodes.containsKey(i[1]))
                child = nodes.get(i[1]);
            else {
                child = new TreeNode(i[1]);
                nodes.put(i[1], child);
            }

            isChild.put(child, true);

            if(i[2]==1)
                parent.left = child;
            else
                parent.right = child;
        }

        for(Map.Entry<TreeNode, Boolean> parent: isChild.entrySet())
            if(!parent.getValue())
                return parent.getKey();
        return null;
    }
}