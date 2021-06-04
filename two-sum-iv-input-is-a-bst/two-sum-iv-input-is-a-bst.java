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
    public List<Integer> inorder(TreeNode root)
    {
        List<Integer>arr=new ArrayList<Integer>();
        if(root==null)
            return arr;
        arr.addAll(inorder(root.left));
        arr.add(root.val);
        arr.addAll(inorder(root.right));
        return arr;
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer>arr=new ArrayList<Integer>();
        arr=inorder(root);
        int i=0,j=arr.size()-1;
        while(i<j)
        {
            if(arr.get(i)+arr.get(j)==k)
                return true;
            else if(arr.get(i)+arr.get(j)<k)
                i++;
            else j--;
                
        }
        return false;
    }
}