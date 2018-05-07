package wang.tyrael.leetcode.linked.sort148;

import wang.tyrael.basic.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode nullHead = new ListNode(0);
        nullHead.next = head;
        sortList(nullHead, null);
        return nullHead.next;
    }

    public void sortList(ListNode head, ListNode tail) {
//        System.out.println("head.value:" + head.val);
        ListNode pivot = head.next;
        if (pivot == tail){
            return;
        }
        ListNode next = pivot.next;
        pivot.next = tail;
        while (next != tail){
            ListNode current = next;
            next = current.next;
            if (pivot.val > current.val){
                current.next = head.next;
                head.next = current;
            }else{
                current.next = pivot.next;
                pivot.next = current;
            }
        }
        sortList(head, pivot);
        sortList(pivot, tail);
    }
}
