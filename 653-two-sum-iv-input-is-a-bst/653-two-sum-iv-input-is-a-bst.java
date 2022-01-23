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
class TreeIterator
{
    Stack<TreeNode>st=new Stack<TreeNode>();
    boolean isReverse;
    TreeIterator(boolean isReverse,TreeNode root)
    {
        this.isReverse=isReverse;
        pushAll(root);
    }
    void pushAll(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            if(!isReverse)
                root=root.left;
            else
                root=root.right;
        }
    }
    int next()
    {
        TreeNode next=st.pop();
        if(isReverse)
            pushAll(next.left);
        else
            pushAll(next.right);
        return next.val;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        TreeIterator left=new TreeIterator(false,root);
        TreeIterator right=new TreeIterator(true,root);
        int i=left.next();
        int j=right.next();
        while(i<j)
        {
            if(i+j==k)
                return true;
            if(i+j<k)
                i=left.next();
            else
                j=right.next();
        }
        return false;
    }
}