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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode back = slow.next;
        ListNode prev = null;
        slow.next = null;
        while(back != null){
            ListNode temp = back.next;
            back.next = prev;
            prev = back;
            back = temp;
        }

        ListNode front = head;
        back = prev;

        while(back != null){
            ListNode temp1 = front.next;
            ListNode temp2 = back.next;
            front.next = back;
            back.next = temp1;
            front = temp1;
            back = temp2;
        }
    }
}
