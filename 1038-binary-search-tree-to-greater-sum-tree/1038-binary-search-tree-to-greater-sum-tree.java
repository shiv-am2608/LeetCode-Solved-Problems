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
    public int recurr(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=recurr(root.left);
        int right=recurr(root.right);
        addToLeft(root.left,right+root.val);
        root.val=root.val+right;
        return root.val+left;
    }
    public void addToLeft(TreeNode root,int x)
    {
        if(root==null)
            return;
        addToLeft(root.left,x);
        addToLeft(root.right,x);
        root.val+=x;
    }
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return root;
        int right=recurr(root.right);
        int left=recurr(root.left);
        addToLeft(root.left,right+root.val);
        root.val=root.val+right;
        return root;
    }
}