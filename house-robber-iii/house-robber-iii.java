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
    HashMap<TreeNode,Integer>hmap=new HashMap<TreeNode,Integer>();
    public int robInclude(TreeNode node)
    {
        if(node==null)
            return 0;
        return robExclude(node.left)+robExclude(node.right)+node.val;
    }

    public int robExclude(TreeNode node)
    {
        if(node == null)
            return 0;
        return rob(node.left)+rob(node.right);
    }

    public int rob(TreeNode root) {
        if (root == null) 
            return 0;
        if(hmap.containsKey(root))
            return hmap.get(root);
        int temp=Math.max(robInclude(root),robExclude(root));
        hmap.put(root,temp);
        return temp;
    }
}