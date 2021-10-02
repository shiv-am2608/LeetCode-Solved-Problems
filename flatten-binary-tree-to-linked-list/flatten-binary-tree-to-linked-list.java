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
   
    public TreeNode helper(TreeNode root)
    {
        if(root==null)
            return root;
        
        TreeNode left = helper(root.left);
        // if(left==null)
        //     return root;
        TreeNode temp = null;
        if(root.right!=null)
        {
            temp = root.right;
              //return helper(temp);
        }
        root.right = left;
         TreeNode curr = root;
        while(curr.right!=null)
        {
            curr = curr.right;
        }
        curr.right = temp;
        root.left = null;
        TreeNode right  = helper(root.right);
        root.right = right;
        return root;
        
    }
    public void flatten(TreeNode root) {
        helper( root);
    }
}