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
    public ListNode mergeKLists(ListNode[] lists) {
        /*
            Create a PQ that will store min elements at the front 
            1) Append all the node values to PQ 
            2) Create a new Node which we will append all of our elements to
            3) Return said node
        */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (ListNode node : lists) {
            while (node != null) {
                minHeap.add(node.val);
                node = node.next;
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = new ListNode(minHeap.remove());
            head.next = node;
            head = head.next;
        }
    
        return dummy.next;
    }
}