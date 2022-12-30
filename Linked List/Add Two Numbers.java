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
        int carry = 0;
        ListNode ret = new ListNode();
        ListNode cur = ret;

        while(l1 != null || l2 != null){
            int a = 0;
            if(l1 != null) a = l1.val;
            int b = 0;
            if(l2 != null) b = l2.val;

            int sum = a + b + carry;

            if(sum >= 10){
                carry = 1;
                cur.next = new ListNode(sum % 10);
            }
            else{
                carry = 0;
                cur.next = new ListNode(sum);
            }
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry == 1) cur.next = new ListNode(1);
        
        return ret.next;
    }
}
