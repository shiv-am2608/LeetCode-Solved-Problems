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
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head,prev=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l=head;
        for(int i=0;i<left-2;i++)
            l=l.next;
        ListNode end=head;
        for(int i=0;i<right-1;i++)
            end=end.next;
        ListNode r=end.next;
        end.next=null;
        if(left==1)
        {
            ListNode temp=reverse(head);
            head.next=r;
            return temp;
            
        }
        ListNode start=l.next;
        l.next=reverse(start);
        start.next=r;
        return head;
        
        
        
    }
}