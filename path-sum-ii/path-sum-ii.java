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
    public void findPath(TreeNode root,int targetSum,int currSum,List<Integer>path,List<List<Integer>>res)
    {
        if(root==null)
            return;
        currSum+=root.val;
        path.add(root.val);
        if(root.right==null && root.left==null && currSum==targetSum)
        {
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        findPath(root.left,targetSum,currSum,path,res);
        findPath(root.right,targetSum,currSum,path,res);
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>path=new ArrayList<Integer>();
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        findPath(root,targetSum,0,path,res);
        return res;
        
    }
}