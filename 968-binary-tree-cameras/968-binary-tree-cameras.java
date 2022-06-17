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
    int count=0;
    HashSet<TreeNode>hs=new HashSet<TreeNode>();
    public void dfs(TreeNode root,TreeNode parent)
    {
        if(root==null)
            return;
        dfs(root.left,root);
        dfs(root.right,root);
        if((parent==null && !hs.contains(root)) || !hs.contains(root.left) || !hs.contains(root.right))
        {
            count++;
            hs.add(root);
            hs.add(root.left);
            hs.add(root.right);
            hs.add(parent);
        }
    }
    public int minCameraCover(TreeNode root) {
        hs.add(null);
        dfs(root,null);
        return count;
    }
}