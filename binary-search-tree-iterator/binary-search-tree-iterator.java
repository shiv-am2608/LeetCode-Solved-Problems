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
class BSTIterator {
    List<Integer>inorder;
    int i;
    public BSTIterator(TreeNode root) {
        inorder=new ArrayList<Integer>();
        traverse(root,inorder);
        i=-1;
    }
    
    public int next() {
        i++;
        return inorder.get(i);
    }
    
    public boolean hasNext() {
        if(i<inorder.size()-1)
            return true;
        return false;
    }
    public void traverse(TreeNode root,List<Integer>res)
    {
        if(root==null)
            return;
        traverse(root.left,res);
        res.add(root.val);
        traverse(root.right,res);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */