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
    public ListNode middleNode(ListNode head) {
        /*
            - Non-empty singly linked list, return a middle node
            - If there are two middle nodes, return the second middle node
        */
        int length = middleNodeHelper(head);
        
        ListNode temp = head; 
        ListNode ans = new ListNode(0);
        
        int target = length / 2;
        int count = 0; 
        
        while (temp != null) { 
            if (count == target) {
                ans = temp;
            }
            count++; 
            temp = temp.next; 
            
        } 
        
        return ans; 
    }
    
    public int middleNodeHelper(ListNode head) {
        ListNode temp = head; 
        int count = 0; 
        while (temp != null) { 
            count++; 
            temp = temp.next; 
        } 
        return count; 
    }
}
