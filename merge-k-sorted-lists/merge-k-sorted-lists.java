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
    public ListNode merge(ListNode head1,ListNode head2)
    {
        if(head1==null && head2==null)
            return null;
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        ListNode res;
        ListNode ptr1=head1;
        ListNode ptr2=head2;
        if(ptr1.val<ptr2.val)
        {
            res=ptr1;
            ptr1=ptr1.next;
        }
        else
        {
            res=ptr2;
            ptr2=ptr2.next;
        }
        ListNode curr=res;
        while(ptr1!=null && ptr2!=null)
        {
            if(ptr1.val<ptr2.val)
            {
                curr.next=ptr1;
                curr=curr.next;
                ptr1=ptr1.next;
            }
            else
            {
                curr.next=ptr2;
                curr=curr.next;
                ptr2=ptr2.next;
            }
        }
        if(ptr1!=null)
            curr.next=ptr1;
        if(ptr2!=null)
            curr.next=ptr2;
        return res;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode res;
        res=lists[0];
        for(int i=1;i<lists.length;i++)
            res=merge(res,lists[i]);
        return res;
    }
}