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
    HashMap<Integer,ListNode>hmap;
    public Solution(ListNode head) {
        hmap=new HashMap<Integer,ListNode>();
        ListNode curr=head;
        int i=0;
        while(curr!=null)
        {
            hmap.put(i,curr);
            i++;
            curr=curr.next;
        }
    }
    
    public int getRandom() {
        return hmap.get((int)(Math.random()*hmap.size())).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */