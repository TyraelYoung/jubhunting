package wang.tyrael.leetcode.mergeK23;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode current;

        ListNode[] a = initArray(lists);
        initHeap(a);
        int length = a.length;
        while (length > 0){
            ListNode next = a[0].next;

            a[0].next = head.next;
            head.next = a[0];

            if(next == null){
                a[0] = a[length-1];
                length--;
            }else{
                a[0] = next;
                adjust(a, 0, length-1);
            }
        }
        return head.next;
    }

    ListNode[] initArray(ListNode[] listNodes){
        List<ListNode> list = new ArrayList<>();


        for (int i = 0; i < listNodes.length; i++) {
            if(listNodes[i] == null){

            }else{
                list.add(listNodes[i]);
            }
        }
        ListNode[] a = new ListNode[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }

        return a;
    }

    void initHeap(ListNode[] listNodes){
        for (int i = listNodes.length/2-1; i >= 0; i--) {
            adjust(listNodes, i, listNodes.length-1);
        }
    }

    void adjust(ListNode[] listNodes, int start, int end) {
        ListNode top = listNodes[start];
        int parent = 0;
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            parent = (i - 1) / 2;
            int min = i;
            if (i + 1 <= end && listNodes[i + 1].val < listNodes[i].val) {
                min = i + 1;
            }
            if (listNodes[min].val < top.val) {
                listNodes[parent] = listNodes[min];
            } else {
                listNodes[parent] = top;
                return;
            }
        }
        listNodes[parent] = top;
    }
}
