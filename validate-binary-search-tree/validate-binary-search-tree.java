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
    public boolean check(TreeNode root,long min,long max)
    {
        if(root==null)
            return true;
        if(root.val<max && root.val>min)
        {
            boolean left=true,right=true;
            if(root.left!=null)
                left=check(root.left,min,root.val);
            if(root.right!=null)
                right=check(root.right,root.val,max);
            return left && right;
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}