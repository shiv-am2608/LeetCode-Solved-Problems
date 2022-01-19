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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode>st=new Stack<TreeNode>();
        Stack<TreeNode>st1=new Stack<TreeNode>();
        List<Integer>arr=new LinkedList<Integer>();
        if(root==null)
            return arr;
        TreeNode curr=root;
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode temp=st.pop();
            st1.push(temp);
            if (temp.left != null)
                st.push(temp.left);
            if (temp.right != null)
                st.push(temp.right);
        }
        while (!st1.isEmpty())
        {
            TreeNode temp = st1.pop();
            arr.add(temp.val);
        }
        return arr;
    }
}