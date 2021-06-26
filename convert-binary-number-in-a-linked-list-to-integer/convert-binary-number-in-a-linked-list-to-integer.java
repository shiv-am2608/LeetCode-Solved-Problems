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
    public int len(ListNode head)
    {
        ListNode ptr=head;
        int count=0;
        while(ptr!=null)
        {
            ptr=ptr.next;
            count++;
        }
        return count;
    }
    public int getValue(ListNode head,int k)
    {
        if(head.next==null)
            if(head.val==1)
                return 1;
            else
                return 0;
        if(head.val==0)
            return getValue(head.next,k-1);
        return getValue(head.next,k-1)+(int)Math.pow(2,k);
        
    }
    public int getDecimalValue(ListNode head) {
        if(head==null)
            return 0;
        int length=len(head);
        return getValue(head,length-1);
    }
}