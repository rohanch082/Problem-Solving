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
    public ListNode insertionSortList(ListNode head) {
        ListNode head1 = null;
        ListNode tail = null;

        ListNode un = head;

        while (un != null) {
            ListNode forward = un.next;
            un.next = null;

            if (head1 == null) {
                head1 = un;
                tail = un;
            } 
            else if (un.val < head1.val) {
                un.next = head1;
                head1 = un;
            } 
            else if (un.val >= tail.val) {
                tail.next = un;
                tail = un;
            } 
            else {
                ListNode temp = head1;

                while (temp.next != null && temp.next.val <= un.val) {
                    temp = temp.next;
                }

                un.next = temp.next;
                temp.next = un;
            }

            un = forward;
        }

        return head1;
    }
}