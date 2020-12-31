/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode nextK = getNextK(curr, k); // finds the next kth node from curr node
        
        while (nextK != null) {
            ListNode tail = curr.next;
            reverseSection(curr, tail, k - 1); // reverse between node and tail node
            curr = tail; // set tail as new curr node
            nextK = getNextK(curr, k);
        }
        
        return dummy.next;
    }
    
    public ListNode getNextK(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
            if (curr == null) {
                break;
            }
        }
        return curr;
    }
    
    public void reverseSection(ListNode curr, ListNode tail, int k) {
        for (int i = 0; i < k; i++) {
            ListNode tmp = tail.next;
            tail.next = tmp.next;
            tmp.next = curr.next;
            curr.next = tmp;
        }
    }
}
