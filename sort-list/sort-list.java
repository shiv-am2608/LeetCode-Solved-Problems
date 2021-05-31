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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1==null && l2==null)
            return null;
        ListNode head;
        if(l1.val<l2.val)
        {
            head=l1;
            l1=l1.next;
        }
        else
        {
            head=l2;
            l2=l2.next;
        }
        ListNode ptr=head;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                ptr.next=l1;
                l1=l1.next;
                ptr=ptr.next;
            }
            else
            {
                ptr.next=l2;
                l2=l2.next;
                ptr=ptr.next;
            }
        }
        if(l1!=null)
            ptr.next=l1;
        if(l2!=null)
            ptr.next=l2;
        return head;
    }
    public ListNode mergeSort(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode left=head;
        ListNode right=slow.next;
        slow.next=null;
        ListNode leftSorted=mergeSort(left);
        ListNode rightSorted=mergeSort(right);
        ListNode fHead=mergeTwoLists(leftSorted,rightSorted);
        return fHead;
        
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}