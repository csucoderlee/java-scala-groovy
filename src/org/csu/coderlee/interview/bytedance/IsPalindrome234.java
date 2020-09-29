package org.csu.coderlee.interview.bytedance;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 请注意
 * 1
 * 1 1
 * 1 0 1
 * 1 0 2 0 1
 * 以上都属于回文链表
 */
public class IsPalindrome234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(isPalindrome(head));

    }

    /**
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        stack.push(cur);
        while(cur.next != null) {
            if (stack.peek().val == cur.next.val) {
                stack.pop();
            } else {
                stack.push(cur.next);
            }
            cur = cur.next;
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
