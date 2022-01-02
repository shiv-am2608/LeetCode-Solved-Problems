/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public ListNode getMiddle(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode getPrev(ListNode head,ListNode target)
    {
        ListNode curr=head;
        while(curr!=null && curr.next!=target)
            curr=curr.next;
        return curr;
    }
    public TreeNode convertListToTree(ListNode head)
    {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        
        ListNode mid=getMiddle(head);
        
        TreeNode root=new TreeNode(mid.val);
        
        ListNode prev=getPrev(head,mid);
        if(prev!=null)
            prev.next=null;
        root.left=convertListToTree(head);
        
        ListNode next=mid.next;
        mid.next=null;
        root.right=convertListToTree(next);
        
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return convertListToTree(head);
    }
}