package wang.tyrael.lintcode.linkedlist.addtwonumber167;

/**
 * @Auther: wangchao
 * @Date: 2018/8/8 15:30
 * @Description:
 */

import wang.tyrael.basic.ListNode;

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 ==null && l2 ==null) return null;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int carry = 0;
        while(l1 != null && l2 !=null){
            int val = l1.val + l2.val +carry;
            carry = val /10;
            val %= 10;

            ListNode listNode = new ListNode(val);
            pre.next = listNode;
            pre = listNode;

            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int val = l1.val + carry;
            carry = val /10;
            val %= 10;

            ListNode listNode = new ListNode(val);
            pre.next = listNode;
            pre = listNode;

            l1 = l1.next;
        }

        while(l2 != null){
            int val = l2.val + carry;
            carry = val /10;
            val %= 10;

            ListNode listNode = new ListNode(val);
            pre.next = listNode;
            pre = listNode;

            l2 = l2.next;
        }

        if (carry != 0){
            ListNode listNode = new ListNode(carry);
            pre.next = listNode;
        }

        return head.next;
    }
}
