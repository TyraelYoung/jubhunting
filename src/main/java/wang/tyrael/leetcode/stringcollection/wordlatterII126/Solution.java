package wang.tyrael.leetcode.stringcollection.wordlatterII126;

import java.util.*;

/**
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * ["hit","hot","lot","log","cog", cob]
 * <p>
 * <p>
 * 1， 暴力 n！ bfs 指数
 * 2，双向bfs
 *
 *
 * 处理一下一个单词对应树中多个节点的问题。
 */

/**
 * 构造一个图，然后深度搜索。
 */
public class Solution {
    static class Node {
        String word;
        int index;
        //        List<Node> children;
        Node parent;

        public Node(int index) {
            this.index = index;
        }

        public Node(String word, int index) {
            this.word = word;
            this.index = index;
        }

        public Node(String word, int index, Node parent) {
            this.word = word;
            this.index = index;
            this.parent = parent;
        }
    }

    private List<String> wordList;
    String endWord;

    /**
     * 1 表示可连通
     * -1 表示不可连通
     * 0 表示没计算
     */
    int[][] graph;
    int endIndex = -1;
    //队列辅助，实现按层访问，宽度搜索

    boolean flagFind = false;

    /**
     * 记录路径关系
     */
    Node startRoot;
    Node endRoot;

    Queue<Node> startQueue;
    Queue<Node> endQueue;

    /**
     * 已访问节点
     */
    Set<String> startSet;
    Set<String> endSet;

    Set<String> meetPoint;

    Map<String, List<Node>> startValueToNode;
    Map<String, List<Node>> endValueToNode;

    static Node LEVEL_END = new Node(-2);

    public void init() {
        endIndex = -1;
        startQueue = new LinkedList<>();
        endQueue = new LinkedList<>();
        flagFind = false;
        startSet = new HashSet();
        endSet = new HashSet();
        startValueToNode = new HashMap<>();
        endValueToNode = new HashMap<>();
        startQueue = new LinkedList<>();
        endQueue = new LinkedList<>();
        meetPoint = new HashSet<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        init();
        //calculateGraph(wordList);
        graph = new int[wordList.size()][wordList.size()];
        this.endWord = endWord;
        this.wordList = wordList;
        for (int i = 0; i < wordList.size(); i++) {
            if (endWord.equals(wordList.get(i))) {
                endIndex = i;
            }
        }
        if (endIndex == -1) {
            return new ArrayList<>();
        }

        startRoot = new Node(beginWord, -1);
        endRoot = new Node(endWord, endIndex);

        initStartQueue(beginWord);
        initEndQueue(endWord);

        if (!flagFind) {
            while (true) {
                boolean toContinueStart = startNextLevel();
                if (flagFind) {
                    break;
                }
                boolean toContinueEnd = endNextLevel();
                if (flagFind) {
                    break;
                }
                if (toContinueStart && toContinueEnd) {

                } else {
                    break;
                }
            }
        }


        if (flagFind) {
            List<List<String>> resultFormat = new ArrayList<>();
            for (String meet : meetPoint) {
                List<Node> meetInEnd = endValueToNode.get(meet);
                List<Node> meetInStart = startValueToNode.get(meet);

                for (Node nodeInStart :
                        meetInStart) {
                    for (Node nodeInEnd :
                            meetInEnd) {
                        List<String> item = new ArrayList<>();

                        Node next = nodeInStart;
                        while (next != null) {
                            item.add(0, next.word);
                            next = next.parent;
                        }
                        next = nodeInEnd.parent;

                        while (next != null) {
                            item.add(next.word);
                            next = next.parent;
                        }
                        resultFormat.add(item);
                    }
                }
            }

            //转化一下
            return resultFormat;
        } else {
            return new ArrayList<>();
        }


    }

    public void putNode(Map<String, List<Node>> map, Node node){
        List<Node> list = map.get(node.word);
        if(list == null){
            list = new ArrayList<>();
            list.add(node);
            map.put(node.word, list);
        }else{
            list.add(node);
        }
    }


    /**
     * 处理一层的结果
     *
     * @return
     */
    boolean endNextLevel() {
        if (endQueue.size() == 1) {
            //只有一个标记节点
            return false;
        }
        while (true) {
            Node next = endQueue.poll();
            if (next.index == -2) {
                //本层处理完毕
                endQueue.add(LEVEL_END);
                return true;
            }

            //子节点加入树，并检查是否碰头了
            for (int i = 0; i < wordList.size(); i++) {

                int isNear = graph[next.index][i];
                if (isNear == 0) {
                    boolean bNear = isNear(wordList.get(next.index), wordList.get(i));
                    if (bNear) {
                        graph[next.index][i] = 1;
                        graph[i][next.index] = 1;
                    } else {
                        graph[next.index][i] = -1;
                        graph[i][next.index] = -1;
                    }
                    isNear = graph[next.index][i];
                }

                String child = wordList.get(i);
                if (isNear == 1 && !endSet.contains(child)) {
                    Node nchild = new Node(wordList.get(i), i, next);
                    endQueue.add(nchild);
                    putNode(endValueToNode, nchild);
                    endSet.add(child);

                    if (startSet.contains(child)) {
                        flagFind = true;
                        meetPoint.add(child);
                    }

                } else {
                    //不相邻，查看下一个节点
                }

            }

        }
    }

    void initStartQueue(String beginWord) {
        for (int i = 0; i < wordList.size(); i++) {
            String b = wordList.get(i);
            if (isNear(beginWord, b)) {
                Node node = new Node(b, i, startRoot);
                startQueue.add(node);
                startSet.add(b);
                putNode(startValueToNode, node);
            }
        }
        startQueue.add(LEVEL_END);
    }

    void initEndQueue(String endWord) {
        endQueue.add(endRoot);
        endSet.add(endWord);
        putNode(endValueToNode, endRoot);
        if (startSet.contains(endWord)) {
            flagFind = true;
            meetPoint.add(endWord);
        }

        endQueue.add(LEVEL_END);
    }

    /**
     * 处理一层的结果
     *
     * @return
     */
    boolean startNextLevel() {
        if (startQueue.size() == 1) {
            //只有一个标记节点
            return false;
        }
        while (true) {
            Node next = startQueue.poll();
            if (next.index == -2) {
                //本层处理完毕
                startQueue.add(LEVEL_END);
                return true;
            }

            //子节点加入树，并检查是否碰头了
            for (int i = 0; i < wordList.size(); i++) {

                int isNear = graph[next.index][i];
                if (isNear == 0) {
                    boolean bNear = isNear(wordList.get(next.index), wordList.get(i));
                    if (bNear) {
                        graph[next.index][i] = 1;
                        graph[i][next.index] = 1;
                    } else {
                        graph[next.index][i] = -1;
                        graph[i][next.index] = -1;
                    }
                    isNear = graph[next.index][i];
                }
                String child = wordList.get(i);
                if (isNear == 1 && !isInPath(next, i)) {
                    Node nchild = new Node(wordList.get(i), i, next);
                    startQueue.add(nchild);
                    putNode(startValueToNode, nchild);
                    startSet.add(child);

                    if (endSet.contains(child)) {
                        flagFind = true;
                        meetPoint.add(child);
                    }

                } else {
                    //不相邻，查看下一个节点
                }

            }
        }
     }

    public boolean isInPath(Node parent, int index){
        while(parent != null){
            if(parent.index == index){
                return true;
            }
            parent = parent.parent;
        }
        return false;
    }


    public void calculateGraph(List<String> wordList) {
        graph = new int[wordList.size()][wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            String a = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String b = wordList.get(j);
                if (isNear(a, b)) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                } else {
                    graph[i][j] = -1;
                    graph[j][i] = -1;
                }
            }
        }
    }

    public void printGraph() {
//        for (int i = 0; i < graph.length; i++) {
//            System.out.println();
//            int[] item = graph[i];
//            for (int j = 0; j < item.length; j++) {
//                System.out.print(" " + item[j]);
//            }
//        }
    }

    /**
     * 不包含相同的
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isNear(String a, String b) {
        int countDiff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {

            } else {
                countDiff++;
            }
            if (countDiff > 1) {
                return false;
            }
        }
        if (countDiff == 0) {
//            throw new RuntimeException("字符串相同");
            return false;
        }
        //==1
        return true;
    }
}
