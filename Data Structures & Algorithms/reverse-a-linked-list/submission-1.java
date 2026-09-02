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
    public ListNode reverseList(ListNode head) {
        // 1 -> 2 -> 3 -> 4
        // p <- h    n
        // 1 <- 2.   3 -> 4
        //      p <- h    n
        // 1 <- 2 <- 3    4
        if (head == null) { return null; }
        if (head.next == null) { return head; }

        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;

        while (nextNode.next != null) {
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.next;

            currentNode.next = previousNode;
        }
        head.next = null;
        nextNode.next = currentNode;
        currentNode = nextNode;   
        return currentNode;
    }
}
