/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1=headA;
        ListNode ptr2=headB;
        while(ptr1!=null && ptr2!=null)
        {
            if(ptr1==ptr2)
                return ptr1;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
            if(ptr1==null && ptr2==null)
                return ptr1;
            if(ptr1==null)
                ptr1=headB;
            if(ptr2==null)
                ptr2=headA;
        }
        return ptr1;
    }
}