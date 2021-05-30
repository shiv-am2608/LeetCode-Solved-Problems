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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode>st=new Stack<TreeNode>();
        List<Integer>arr=new LinkedList<Integer>();
        TreeNode curr=root;
        while(curr!=null || st.size()>0)
        {
            while(curr!=null)
            {
                arr.add(curr.val);
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            curr=curr.right;   
        }
        return arr;
    }
}