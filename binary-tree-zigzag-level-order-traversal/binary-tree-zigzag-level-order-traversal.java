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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        Stack<Integer>st=new Stack<Integer>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty())
        {
            ArrayList<Integer>arr=new ArrayList<Integer>();
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(level%2==1)
                    st.push(curr.val);
                else
                    arr.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            while(!st.isEmpty())
                arr.add(st.pop());
            res.add(arr);
            level++;
        }
        return res;
    }
}