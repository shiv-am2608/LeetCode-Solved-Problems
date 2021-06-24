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
        ListNode prev=null,curr=head;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start=null,end=head;
        ListNode ptr1=head,ptr2=null;
        ListNode res=head;
        while(true)
        {
            int temp=k;
            while(temp-->0 && end!=null)
            {
                ptr2=end;
                end=end.next;
            }
            if(temp!=-1)
                break;
            ptr2.next=null;
            if(start==null)
            {
                start=reverse(ptr1);
                res=start;
            }
            else
                start.next=reverse(ptr1);
            ptr1.next=end;
            start=ptr1;
            ptr1=end;
        }
        return res;
    }
}