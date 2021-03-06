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
        if (head == null || head.next == null) 
            return;
        
        ListNode l1 = head; // head of first half
        ListNode slow = head; // head of second half 
        ListNode fast = head; // tail of second half 
        ListNode prev = null; // tail of first half
        
        // FIND MID POINT 
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        // REVERSE 
        ListNode l2 = reverse(slow);
        
        // MERGE
        merge(l1, l2);
    }
    
    public void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
        
            if (n1 == null)
                break;
            
            l2.next = n1;
            l1 = n1;
            l2 = n2;
      }
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }
}