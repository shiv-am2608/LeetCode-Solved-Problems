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
    TreeNode head=null,prev=null;
    public void recur(TreeNode root)
    {
        if(root==null)
            return;
        recur(root.left);
        if(prev==null)
        {
            head=root;
            prev=root;
        }
        else
        {
            prev.right=root;
            root.left=null;
            prev=root;
        }
        recur(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        recur(root);
        return head;
    }
}