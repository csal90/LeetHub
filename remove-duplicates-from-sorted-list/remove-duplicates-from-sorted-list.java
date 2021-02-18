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
    
        ListNode sentinal = head;
        
        while (sentinal != null && sentinal.next != null) {
            if (sentinal.next.val == sentinal.val) {
                sentinal.next = sentinal.next.next;
            } else {
                sentinal = sentinal.next;
            }
        }
        
        return head; 
    }
}