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
    
    public ListNode rotateRight(ListNode head, int k) {
         if (head==null || k==0 || head.next==null)
            return head;
        int len=1;
        ListNode curr = head;
        while (curr.next != null)
        {
            len++;
            curr = curr.next;
        }
        k = k%len;
        curr.next = head;
        for (int i=0; i<len-k; i++)
            curr = curr.next;
        head = curr.next;
        curr.next = null;
        return head;
        
    }
}