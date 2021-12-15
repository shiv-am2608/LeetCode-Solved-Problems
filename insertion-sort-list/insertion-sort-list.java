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
class Solution {
    public ListNode insert(ListNode head,ListNode curr)
    {
        ListNode ptr=head,prev=null;
        while(ptr!=null && ptr.val<curr.val)
        {
            prev=ptr;
            ptr=ptr.next;
        }
        curr.next=ptr;
        if(prev==null)
            return curr;
        prev.next=curr;
        return head;
    }
    public ListNode getLast(ListNode head)
    {
        if(head==null)
            return head;
        ListNode ptr=head;
        while(ptr.next!=null)
            ptr=ptr.next;
        return ptr;
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode prev=head,curr=head.next;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=null;
            prev.next=null;
            head=insert(head,curr);
            prev=getLast(head);
            prev.next=next;
            curr=next;
        }
        return head;
    }
}