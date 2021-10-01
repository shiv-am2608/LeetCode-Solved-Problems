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
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void recover(TreeNode root)
    {
        if(root==null)
            return;
        recover(root.left);
        if(first==null && root.val<prev.val)
            first=prev;
        if(first!=null && root.val<prev.val)
            second=root;
        prev=root;
        recover(root.right);
    }
    public void recoverTree(TreeNode root) {
        recover(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
}