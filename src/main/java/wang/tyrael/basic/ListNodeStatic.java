package wang.tyrael.basic;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class ListNodeStatic {
    public static void print(ListNode head){
        System.out.println();
        while (head != null){
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode parse(String s){
        List<Integer> list = JSON.parseArray(s, Integer.class);
        if (list.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode pre = head;
        for (int i = 1; i < list.size(); i++) {
            ListNode c = new ListNode(list.get(i));
            pre.next = c;
            pre = c;
        }
        return head;
    }
}
