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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || (head.next==null && n==1))
            return null;
        ListNode ptr=head;
        for(int i=0;i<n;i++)
            ptr=ptr.next;
        if(ptr==null)
            return head.next;
        ListNode ptr2=head;
        while(ptr.next!=null)
        {
            ptr=ptr.next;
            ptr2=ptr2.next;
        }
        ptr2.next=ptr2.next.next;
        return head;
    }
}