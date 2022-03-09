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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode curr=head;
        boolean dup=false;
        while(curr.next!=null && curr.val==curr.next.val)
        {
            dup=true;
            curr=curr.next;
        }
        if(dup)
            head=deleteDuplicates(curr.next);
        else
            curr.next=deleteDuplicates(curr.next);
        return head;
    }
}