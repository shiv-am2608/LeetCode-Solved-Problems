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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode add=new TreeNode(val);
        if(root==null)
            return add;
        TreeNode curr=root;
        boolean isAttached=false;
        while(!isAttached)
        {
            if(curr.val>val)
            {
                if(curr.left==null)
                {
                    curr.left=add;
                    isAttached=true;
                }
                else
                    curr=curr.left;
            }
            else
            {
                if(curr.right==null)
                {
                    curr.right=add;
                    isAttached=true;
                }
                else
                    curr=curr.right;
            }
        }
        return root;
    }
}