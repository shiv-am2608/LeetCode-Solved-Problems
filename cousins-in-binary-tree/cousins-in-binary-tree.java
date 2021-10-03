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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y)
            return false;
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        boolean othervisited=false;
        int arr[]=new int[2];
        Arrays.fill(arr,-1);
        q.offer(root);
        int level=0;
        while(!q.isEmpty())
        {
            level++;
            int size=q.size();
            while(size-->0)
            {
                TreeNode curr=q.poll();
                int l=-1,r=-1;
                if(curr.left!=null)
                {
                    l=curr.left.val;
                    q.offer(curr.left);
                }
                if(curr.right!=null)
                {
                    r=curr.right.val;
                    q.offer(curr.right);
                }
                if(l!=-1)
                {
                    if(l==x || l==y)
                    {
                        if(!othervisited)
                        {
                            othervisited=true;
                            arr[0]=curr.val;
                            arr[1]=level;
                        }
                        else if(arr[1]==level &&  arr[0]!=curr.val)
                            return true;
                        else
                            return false;
                    }
                }
                if(r!=-1)
                {
                    if(r==x || r==y)
                    {
                        if(!othervisited)
                        {
                            othervisited=true;
                            arr[0]=curr.val;
                            arr[1]=level;
                        }
                        else if(arr[1]==level && arr[0]!=curr.val)
                            return true;
                        else
                            return false;
                    }
                }   
            }
        }
        return false;
    }
}