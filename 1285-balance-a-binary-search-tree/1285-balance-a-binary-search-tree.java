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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> sortedNodes = new ArrayList<>();
        inOrderTraversal(sortedNodes, root);
        return convertToBalancedTree(sortedNodes, 0, sortedNodes.size() - 1);
    }

    public void inOrderTraversal(List<TreeNode> sortedNodes, TreeNode root){
        if(root == null)
            return;
        inOrderTraversal(sortedNodes, root.left);
        sortedNodes.add(root);
        inOrderTraversal(sortedNodes, root.right);
    }

    public TreeNode convertToBalancedTree(List<TreeNode> sortedNodes, int start, int end){
        if(start>end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedNodes.get(mid);
        root.left = convertToBalancedTree(sortedNodes, start, mid-1);
        root.right = convertToBalancedTree(sortedNodes, mid+1, end);
        return root;
    }
}