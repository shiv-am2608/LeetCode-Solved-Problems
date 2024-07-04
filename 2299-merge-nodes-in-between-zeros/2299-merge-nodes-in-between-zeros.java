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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode();
        ListNode curr = ans;
        ListNode ptr = head.next;
        int sum = 0;
        while(ptr!=null){
            if(ptr.val == 0){
                ptr = ptr.next;
                curr.next = new ListNode(sum);
                curr = curr.next;
                sum = 0;
            }else{
                sum += ptr.val;
                ptr=ptr.next;
            }
        }
        return ans.next;
    }
}