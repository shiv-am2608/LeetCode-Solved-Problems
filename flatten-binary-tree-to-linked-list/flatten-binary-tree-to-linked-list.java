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
    public void pre(TreeNode root,Stack<TreeNode>st)
    {
        if(root==null)
            return;
        if(root.right!=null)
            st.push(root.right);
        root.right=root.left;
        root.left=null;
        if(root.right!=null)
            pre(root.right,st);
        else if(!st.isEmpty())
        {
            root.right=st.pop();
            pre(root.right,st);
        }

    }
    public void flatten(TreeNode root) {
        Stack<TreeNode>st=new Stack<TreeNode>();
        pre(root,st);
    }
}