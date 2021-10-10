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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer>arr=new ArrayList<Integer>();
            int size=q.size();
            while(size-->0)
            {
                TreeNode curr=q.poll();
                arr.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            res.add(arr);
        }
        return res;
    }
}