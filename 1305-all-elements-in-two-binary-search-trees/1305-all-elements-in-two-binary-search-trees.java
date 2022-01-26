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
class BSTIterator
{
    Stack<TreeNode>st;
    TreeNode root;
    BSTIterator(TreeNode root)
    {
        st=new Stack<TreeNode>();
        this.root=root;
        pushAll(root);
    }
    void pushAll(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }
    boolean hasNext()
    {
        return !st.isEmpty();
    }
    int getNext()
    {
        TreeNode curr=st.pop();
        pushAll(curr.right);
        return curr.val;
    }
    int peek()
    {
        return st.peek().val;
    }
}
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>res=new ArrayList<Integer>();
        BSTIterator x=new BSTIterator(root1);
        BSTIterator y=new BSTIterator(root2);
        while(x.hasNext() && y.hasNext())
        {
            if(x.peek()<y.peek())
                res.add(x.getNext());
            else
                res.add(y.getNext());
        }
        while(x.hasNext())
            res.add(x.getNext());
        while(y.hasNext())
            res.add(y.getNext());
        return res;
    }
}