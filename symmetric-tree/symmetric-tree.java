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
    public boolean isIdentical(TreeNode p,TreeNode q)
    {
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isIdentical(p.left,q.right) && isIdentical(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return isIdentical(root.left,root.right);
    }
}