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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;

        ListNode temp = new ListNode(0);
        temp.next = head;
        
        ListNode left = temp;
        ListNode right = temp;
        
        while(n > 0){
            right = right.next;
            n--;
        }

        while(right.next != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return temp.next;
    }
}
