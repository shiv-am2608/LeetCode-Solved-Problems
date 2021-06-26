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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ptr=list2;
        while(ptr.next!=null)
            ptr=ptr.next;
        ListNode start=list1;
        for(int i=1;i<a;i++)
            start=start.next;
        ListNode end=list1;
        for(int i=0;i<b+1;i++)
            end=end.next;
        start.next=list2;
        ptr.next=end;
        return list1;
    }
}