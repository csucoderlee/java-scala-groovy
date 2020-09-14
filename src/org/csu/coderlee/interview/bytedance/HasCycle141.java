package org.csu.coderlee.interview.bytedance;


/**
 * 给定一个链表，判断链表中是否有环。
 */
public class HasCycle141 {

    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
