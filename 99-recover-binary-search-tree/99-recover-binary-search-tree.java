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
    TreeNode left,right,mid,prev;
    public void inOrder(TreeNode root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        if(prev!=null && root.val<prev.val)
        {
            if(left==null)
            {
                left=prev;
                mid=root;
            }
            else
                right=root;
        }
        prev=root;
        inOrder(root.right);
    }
    public void swap(TreeNode x,TreeNode y)
    {
        int temp=x.val;
        x.val=y.val;
        y.val=temp;
    }
    public void recoverTree(TreeNode root) {
        left=null;
        mid=null;
        right=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        if(left!=null && right!=null)
            swap(left,right);
        else if(left!=null && mid!=null)
            swap(left,mid);
    }
}