package wang.tyrael.leetcode.wordlatterII126;

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

    List<String> meetPoint;

    Map<String, Node> startValueToNode;
    Map<String, Node> endValueToNode;

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
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        init();
        calculateGraph(wordList);
        //graph = new int[wordList.size()][wordList.size()];
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
        startQueue.add(startRoot);
        startQueue.add(LEVEL_END);
        endQueue.add(endRoot);
        endQueue.add(LEVEL_END);
        startSet.add(beginWord);
        endSet.add(endWord);
        startValueToNode.put(beginWord, startRoot);
        endValueToNode.put(endWord, endRoot);

        while (true) {
            boolean toContinueStart = startNextLevel();
            if(flagFind){
                break;
            }
            boolean toContinueEnd = endNextLevel();
            if(flagFind){
                break;
            }
            if (toContinueStart && toContinueEnd) {

            } else {
                break;
            }
        }
        if (flagFind) {

            List<List<String>> resultFormat = new ArrayList<>();
            for (String meet : meetPoint) {
                Node meetInEnd = endValueToNode.get(meet);
                Node meetInStart = startValueToNode.get(meet);

                List<String> item = new ArrayList<>();

                Node next = meetInStart;
                while (next != null) {
                    item.add(0, next.word);
                    next = next.parent;
                }
                next = meetInEnd;
                while (next != null) {
                    item.add(next.word);
                    next = next.parent;
                }
                resultFormat.add(item);
            }

            //转化一下
            return resultFormat;
        } else {
            return new ArrayList<>();
        }


    }

    /**
     * 处理一层的结果
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
                    startValueToNode.put(child, nchild);
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

    /**
     * 处理一层的结果
     * @return
     */
    boolean startNextLevel() {
        if (startQueue.size() == 1) {
            //只有一个标记节点
            return false;
        }
        while (!startQueue.isEmpty()) {
            Node next = startQueue.poll();
            if (next.index == -2) {
                //本层处理完毕
                startQueue.add(LEVEL_END);
                return true;
            } else {
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
                    if (isNear == 1 && !startSet.contains(child)) {
                        Node nchild = new Node(wordList.get(i), i, next);
                        startQueue.add(nchild);
                        startValueToNode.put(child, nchild);
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
        throw new RuntimeException();
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
        for (int i = 0; i < graph.length; i++) {
            System.out.println();
            int[] item = graph[i];
            for (int j = 0; j < item.length; j++) {
                System.out.print(" " + item[j]);
            }
        }
    }

    /**
     * 不包含相同的
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
