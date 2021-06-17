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
    public int depth(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=depth(root.left);
        int right=depth(root.right);
        return 1+Math.max(left,right);
    }
    public int doBT(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=diameterOfBinaryTree(root.left);
        int right=diameterOfBinaryTree(root.right);
        int dl=depth(root.left);
        int dr=depth(root.right);
        int di=dl+dr;
        return Math.max(Math.max(left,right),di);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return doBT(root);
        
    }
}