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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode ptr_odd=odd;
        ListNode ptr_even=even;
        ListNode ptr=even.next;
        odd.next=null;
        even.next=null;
        boolean flag=true;
        while(ptr!=null)
        {
            if(flag)
            {
                flag=false;
                ptr_odd.next=ptr;
                ptr_odd=ptr;
                ptr=ptr.next;
                ptr_odd.next=null;
            }
            else
            {
                flag=true;
                ptr_even.next=ptr;
                ptr_even=ptr;
                ptr=ptr.next;
                ptr_even.next=null;
            }
        }
        ptr_odd.next=even;
        return odd;
    }
}