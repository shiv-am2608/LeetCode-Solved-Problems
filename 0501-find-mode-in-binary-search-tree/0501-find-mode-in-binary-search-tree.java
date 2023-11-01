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
    int max = 0;
    Integer prev = null;
    int count = 1;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer>ans=new ArrayList<Integer>();
        traverse(root,ans);
        int res[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i]=ans.get(i);
        return res;
    }
    public void traverse(TreeNode root,ArrayList<Integer>ans){
        if(root == null)
            return;
        traverse(root.left,ans);
        if(prev!=null){
            if(root.val == prev)
                count++;
            else
                count=1;
        }
        if(count > max){
            max = count;
            ans.clear();
            ans.add(root.val);
        }
        else if(count == max)
            ans.add(root.val);
        prev=root.val;
        traverse(root.right,ans);
    }
}