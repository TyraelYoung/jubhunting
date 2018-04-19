package wang.tyrael.leetcode.minimumsubstring;

import java.util.*;

/**
 * @author: wangchao
 * 2018/4/19 0019
 */
public class Solution {
    class Node {
        int index;
        char value;

        public Node(int index, char value) {
            this.index = index;
            this.value = value;
        }
    }


    Map<Character, Integer> targetCount = new HashMap<>();
    Map<Character, Integer> foundCount = new HashMap<>();

    TreeMap<Integer, Node> indexToNode = new TreeMap<>();
    Map<Character, List<Integer>> valueToIndex = new HashMap<>();

    void initTargetCount(String t) {
        for (int i = 0; i < t.length(); i++) {
            int count = targetCount.getOrDefault(t.charAt(i), 0) + 1;
            targetCount.put(t.charAt(i), count);
        }
    }

    public String minWindow(String s, String t) {
        initTargetCount(t);
        int min = Integer.MAX_VALUE;
        String sMin = "";
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (t.contains("" + current)) {
                Node newNode = new Node(i, current);
                //找到一个包含值
                int fCount = foundCount.getOrDefault(current, 0);
                int limitCount = targetCount.getOrDefault(current, 0);
                if (fCount == limitCount) {
                    //已经超限了
                    //删除最左的索引记录，方便后续往右推
                    List<Integer> indexes = valueToIndex.get(current);
                    if (indexes == null) {
                        //不需要该字母
                    } else {

                        int mostLeft = indexes.remove(0);
                        //移除旧的
                        indexToNode.remove(mostLeft);
                        //加入新的
                        indexToNode.put(i, newNode);

                        //索引
                        indexes.add(i);
                    }
                } else {
                    //未超限，直接加入
                    indexToNode.put(i, newNode);
                    List<Integer> indexes = valueToIndex.get(current);
                    if (indexes == null) {
                        indexes = new ArrayList<>();
                    }
                    indexes.add(i);
                    valueToIndex.put(current, indexes);

                    foundCount.put(current, fCount+1);
                }


                //是否已经全了
                if (indexToNode.entrySet().size() == t.length()) {
                    //全了，计算一下长度
                    Map.Entry<Integer, Node> first = indexToNode.firstEntry();
                    Map.Entry<Integer, Node> last = indexToNode.lastEntry();
                    int candidate = last.getKey() - first.getKey();
                    if (candidate < min) {
                        min = candidate;
                        sMin = s.substring(first.getKey(), last.getKey() + 1);
                    }

                    //查找下一个符合条件的索引
                    // 移除第一个元素
                    indexToNode.remove(first.getKey());

                    List<Integer> list = valueToIndex.get(first.getValue().value);
                    list.remove(0);

                    int fCountRemove = foundCount.get(first.getValue().value);
                    foundCount.put(first.getValue().value, fCountRemove-1);
                }

            }
        }
        return sMin;
    }
}
