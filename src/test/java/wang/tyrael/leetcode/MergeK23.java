package wang.tyrael.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import wang.tyrael.leetcode.mergeK23.ListNode;
import wang.tyrael.leetcode.mergeK23.Solution;

import java.util.List;

public class MergeK23 {
    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode[] listNodes = new ListNode[1];
        listNodes[0] = null;
        ListNode result;
        result = solution.mergeKLists(listNodes);
        print(result);

        listNodes = parse("[[1],[0]]");
        result = solution.mergeKLists(listNodes);
        print(result);

        listNodes = parse("[[5, 2, 0]]");
        result = solution.mergeKLists(listNodes);
        print(result);

    }

    void print(ListNode listNode){
        ListNode current = listNode;
        while (current != null){
            System.out.print("" + current.val + ",");
            current = current.next;
        }
        System.out.println();
    }

    ListNode[] parse(String s){
        List<String> list = JSON.parseArray(s, String.class);
        ListNode[] a = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list1 = JSON.parseArray(list.get(i), Integer.class);
            if(list1.size() == 0){
                a[i] = null;
            }
            ListNode head = new ListNode(list1.get(0));
            a[i] = head;
            ListNode current = head;
            for (int j = 1; j < list1.size(); j++) {
                ListNode n = new ListNode(list1.get(j));
                current.next = n;
                current = n;
            }
            current.next = null;
        }
        return a;
    }
}
