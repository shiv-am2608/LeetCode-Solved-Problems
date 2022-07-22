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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;
        ListNode less =null,more=null;
        ListNode less_ptr=null,more_ptr=null;
        ListNode ptr=head;
        while(ptr!=null)
        {
            int val = ptr.val;
            if(val<x)
            {
                if(less==null)
                {
                    less=ptr;
                    less_ptr=ptr;
                }
                else
                    less_ptr.next=ptr;
                less_ptr=ptr;
                ptr=ptr.next;
                less_ptr.next=null;
            }
            else
            {
                if(more==null)
                {
                    more=ptr;
                    more_ptr=ptr;
                }
                else
                    more_ptr.next=ptr;
                more_ptr=ptr;
                ptr=ptr.next;
                more_ptr.next=null;
            }
        }
        if(less==null)
            return more;
        less_ptr.next=more;
        return less;
    }
}