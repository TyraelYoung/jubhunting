package wang.tyrael.leetcode.smallestrange632;

import java.util.*;

/**
 * @author: wangchao
 * 2018/4/25 0025
 */
public class Solution {
    class Node implements Comparable<Node>{
        int coordinate;
        int tagList;

        public Node(int coordinate, int tagList) {
            this.coordinate = coordinate;
            this.tagList = tagList;
        }

        @Override
        public int compareTo(Node o) {
            return coordinate - o.coordinate;
        }
    }

    List<List<Integer>> nums;

    int listCount ;
    //有重复
    TreeMap<Integer, List<Node>> windowCoordinateToNode = new TreeMap<>();
    //不会重复
    Map<Integer, Node> windowTagToNode = new HashMap<>();

    /**
     * 用于从多个列表中取出最小的值
     */
    PriorityQueue<Node> queue = new PriorityQueue<>();

    public int[] smallestRange(List<List<Integer>> nums) {
        this.nums = nums;
        listCount = nums.size();

       initInput();

        if(queue.size() < listCount){
            return new int[]{0, 0};
        }

        boolean flagFound = false;
        int candidateStart = 0, candidateEnd = 0;

        while(hasNext()){
            Node current = next();
            addToWindow(current);
            if(isWindowFull()){
                if(flagFound){
                    if (getWindowSize() < candidateEnd - candidateStart){
                        candidateStart = getWindowStart();
                        candidateEnd = getWindowEnd();
                    }
                }else{
                    candidateStart = getWindowStart();
                    candidateEnd = getWindowEnd();
                    flagFound = true;
                }

                //需找下一个
                removeWindowFirst();
            }
        }

        if (flagFound){
            return new int[]{candidateStart, candidateEnd};
        }else{
            return new int[]{0,0};
        }
    }

    private Node next(){
        Node min = queue.poll();
        List<Integer> list = nums.get(min.tagList);
        if(!list.isEmpty()){
            queue.add(new Node(list.remove(0), min.tagList));
        }
        return min;
    }

    private boolean hasNext(){
        return !queue.isEmpty();
    }

    private void initInput(){
        //把每个list的第一个元素放到heap中
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            if(list.isEmpty()){

            }else{
                queue.add(new Node(list.remove(0), i));
            }
        }
    }

    private int getWindowSize(){
        return getWindowEnd() -getWindowStart();
    }

    private void removeWindowFirst(){
        List<Node> list = windowCoordinateToNode.firstEntry().getValue();
        Node first = list.remove(0);
        if (list.isEmpty()){
            windowCoordinateToNode.remove(first.coordinate);
        }
        windowTagToNode.remove(first.tagList);
    }

    private int getWindowStart(){
        return windowCoordinateToNode.firstEntry().getKey();
    }

    private int getWindowEnd(){
        return windowCoordinateToNode.lastEntry().getKey();
    }

    private boolean isWindowFull(){
        return windowTagToNode.size() == listCount;
    }

    private void addToWindow(Node current){
        //每个组，窗口只保留单一元素，方便后续指针滑动，以及最小距离计算
        Node exist = windowTagToNode.get(current.tagList);
        if (exist == null){

        }else{
            windowTagToNode.remove(exist.tagList);
            List<Node> list = windowCoordinateToNode.get(exist.coordinate);
            Iterator<Node> iterator = list.iterator();
            while (iterator.hasNext()){
                Node node = iterator.next();
                if (node.tagList == current.tagList){
                    iterator.remove();
                    break;
                }
            }
            if (list.isEmpty()){
                windowCoordinateToNode.remove(exist.coordinate);
            }
        }
        windowTagToNode.put(current.tagList, current);
        List<Node> nodes = windowCoordinateToNode.get(current.coordinate);
        if (nodes != null){
            nodes.add(current);
        }else{
            nodes = new ArrayList<>();
            nodes.add(current);
            windowCoordinateToNode.put(current.coordinate, nodes);
        }
    }
}
