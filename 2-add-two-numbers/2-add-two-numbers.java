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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1=l1;
        ListNode ptr2=l2;
        ListNode head=new ListNode((ptr1.val+ptr2.val)%10);
        int carry=(ptr1.val+ptr2.val)/10;
        ptr1=ptr1.next;
        ptr2=ptr2.next;
        ListNode ptr=head;
        while(ptr1!=null && ptr2!=null)
        {
            ptr.next=new ListNode((ptr1.val+ptr2.val+carry)%10);
            ptr=ptr.next;
            carry=(ptr1.val+ptr2.val+carry)/10;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        while(ptr1!=null)
        {
            ptr.next=new ListNode((ptr1.val+carry)%10);
            ptr=ptr.next;
            carry=(ptr1.val+carry)/10;
            ptr1=ptr1.next;
        }
        while(ptr2!=null)
        {
            ptr.next=new ListNode((ptr2.val+carry)%10);
            ptr=ptr.next;
            carry=(ptr2.val+carry)/10;
            ptr2=ptr2.next;
        }
        if(carry!=0)
            ptr.next=new ListNode(carry);
        return head;
    }
}