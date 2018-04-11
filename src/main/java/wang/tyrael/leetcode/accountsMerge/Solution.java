package wang.tyrael.leetcode.accountsMerge;

import java.util.*;

public class Solution {
    class Node{
        String name;
        Set<String> emails = new HashSet<>();
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //email->node
        Map<String, Node> map = new HashMap<>();
        for (List<String> item :
                accounts) {
            Node merged = initMerge(item);
            for (int i = 1; i < item.size(); i++) {
                String email = item.get(i);
                Node list = map.get(email);
                if(list == null){
//                    map.put(email, item);
                }else{
                    //合并
                    merge(merged, list);
                }
            }
            for (String email :
                    merged.emails) {
                map.put(email, merged);
            }

        }
        List<List<String>> result = new ArrayList<>();
        Set<Node> nodesVisited = new HashSet<>();
        for (Map.Entry<String, Node> entry:
             map.entrySet()) {
            Node node = entry.getValue();
            if(nodesVisited.contains(node)){
                continue;
            }
            nodesVisited.add(node);
            List<String> list = new ArrayList<>();
            for (String email:
                 node.emails) {
                list.add(email);
            }
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            list.add(0, node.name);
            result.add(list);
        }
        return result;
    }

    public Node initMerge(List<String> main){
        Node node = new Node();
        node.name = main.get(0);
        for (int i = 1; i < main.size(); i++) {
            node.emails.add(main.get(i));
        }
        return node;
    }

    public void merge(Node main, Node supply){
        main.emails.addAll(supply.emails);
    }

}
