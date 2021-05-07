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
    ListNode reverse(ListNode head)
    {
        ListNode prev=null,curr=head,next=head.next;
        while(next!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        if(head==null || head.next==null)
            return true;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverse(slow.next);
        slow=slow.next;
        fast=head;
        while(slow!=null)
        {
            if(slow.val!=fast.val)
                break;
            slow=slow.next;
            fast=fast.next;
        }
        return (slow==null);
    }
}