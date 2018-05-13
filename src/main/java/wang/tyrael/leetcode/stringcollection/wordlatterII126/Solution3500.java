package wang.tyrael.leetcode.stringcollection.wordlatterII126;

import wang.tyrael.basic.TreeNode;

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
public class Solution3500 {
    public static long timeIsNear = 0;
    public static long timeIsNearCompare = 0;


    private List<String> wordList;
    String endWord;

    /**
     * 缓存
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
    public TreeNode startRoot;
    public TreeNode endRoot;

    //每个层次
    Queue<TreeNode> startQueue;
    Queue<TreeNode> endQueue;

    public int countLevel;

    /**
     * 已访问节点
     */
    Set<String> startSet;
    Set<String> endSet;

    Set<String> startSetThisLevel = new HashSet<>();
    Set<String> endSetThisLevel = new HashSet<>();
    Set<String> seenThisLevel = new HashSet<>();

    Set<String> meetPoint;

    Map<String, List<TreeNode>> startValueToNode;
    Map<String, List<TreeNode>> endValueToNode;

    static TreeNode LEVEL_END = new TreeNode(-2);

    {
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
        //calculateGraph(wordList);
        //用于缓存，防止多次比较
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

        startRoot = new TreeNode(beginWord, -1);
        endRoot = new TreeNode(endWord, endIndex);

        initStartQueue(beginWord);
        initEndQueue(endWord);


        countLevel = 0;
        //双端bfs，每端只要一半就可以了
        int limit = wordList.size()/2;
        if (!flagFind) {
            //long startWhile = System.currentTimeMillis();
            while (countLevel < limit +1) {
                countLevel ++;
                boolean toContinueEnd = oneEndOneLevel(endQueue, endSet, endValueToNode, startSet, meetPoint);
                if (flagFind) {
                    break;
                }
                boolean toContinueStart = oneEndOneLevel(startQueue, startSet, startValueToNode, endSet, meetPoint);
                if (flagFind) {
                    break;
                }

                if (toContinueStart && toContinueEnd) {

                } else {
                    break;
                }
            }
            //long endWhile = System.currentTimeMillis();
            //System.out.println("循环层次：" + (endWhile-startWhile));
        }
        //System.out.println("搜索树深度：" + count);

        return formatResult();
    }

    public List<List<String>> formatResult(){
        if (flagFind) {
            List<List<String>> resultFormat = new ArrayList<>();
            for (String meet : meetPoint) {
                List<TreeNode> meetInEnd = endValueToNode.get(meet);
                List<TreeNode> meetInStart = startValueToNode.get(meet);

                for (TreeNode treeNodeInStart :
                        meetInStart) {
                    for (TreeNode treeNodeInEnd :
                            meetInEnd) {
                        List<String> item = new ArrayList<>();

                        TreeNode next = treeNodeInStart;
                        while (next != null) {
                            item.add(0, next.word);
                            next = next.parent;
                        }
                        next = treeNodeInEnd.parent;

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

    public void putNode(Map<String, List<TreeNode>> map, TreeNode treeNode){
        List<TreeNode> list = map.get(treeNode.word);
        if(list == null){
            list = new ArrayList<>();
            list.add(treeNode);
            map.put(treeNode.word, list);
        }else{
            list.add(treeNode);
        }
    }

    void initStartQueue(String beginWord) {
        for (int i = 0; i < wordList.size(); i++) {
            String b = wordList.get(i);
            if (isNear(beginWord, b)) {
                TreeNode treeNode = new TreeNode(b, i, startRoot);
                startRoot.children.add(treeNode);
                startQueue.add(treeNode);
                startSet.add(b);
                putNode(startValueToNode, treeNode);
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
    boolean oneEndOneLevel(Queue<TreeNode> queue, Set<String> seen,
                           Map<String, List<TreeNode>> valueToNode, Set<String> other, Set<String> meetPoint){
        if (queue.size() == 1) {
            //只有一个标记节点
            return false;
        }
        seenThisLevel.clear();
        while (true) {
            TreeNode next = queue.poll();
            if (next.index == -2) {
                //本层处理完毕
                seen.addAll(seenThisLevel);
                queue.add(LEVEL_END);
                return true;
            }

            //子节点加入树，并检查是否碰头了
            //查找每一个单词，是否是当前单词的变种
            for (int i = 0; i < wordList.size(); i++) {
                String thisWord =  wordList.get(i);
                if(seen.contains(thisWord)){
                    //上面层次已经包含该单词
                    continue;
                }
                int isNear = isNear(next.index, i);
                if (isNear == 1 ) {
                    TreeNode nchild = new TreeNode(thisWord, i, next);
                    queue.add(nchild);
                    putNode(valueToNode, nchild);
                    seenThisLevel.add(thisWord);
                    next.children.add(nchild);

                    if (other.contains(thisWord)) {
                        flagFind = true;
                        meetPoint.add(thisWord);
                    }

                }
//                else {
//                    //不相邻，查看下一个节点
//                }

            }
        }
     }

    public boolean isInPath(TreeNode parent, int index){
        while(parent != null){
            if(parent.index == index){
                return true;
            }
            parent = parent.parent;
        }
        return false;
    }


    /**
     * 提前计算是否相邻
     * @param wordList
     */
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

    public int isNear(int a, int b){
        long start = System.currentTimeMillis();
        int isNear = graph[a][b];
        if (isNear == 0) {
            boolean bNear = isNear(wordList.get(a), wordList.get(b));
            if (bNear) {
                graph[a][b] = 1;
                graph[b][a] = 1;
            } else {
                graph[a][b] = -1;
                graph[b][a] = -1;
            }
            isNear = graph[a][b];
        }
//        int isNear = isNear(wordList.get(a), wordList.get(b))?1:-1;
        long end = System.currentTimeMillis();
        timeIsNear = timeIsNear + (end - start);
        return isNear;
    }

    /**
     * 不包含相同的
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isNear(String a, String b) {
        long start = System.currentTimeMillis();
        boolean result = true;
        int countDiff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {

            } else {
                countDiff++;
            }
            if (countDiff > 1) {
                result =false;
                break;
            }
        }
        if (countDiff == 0) {
//            throw new RuntimeException("字符串相同");
            result = false;
        }
        //==1
        long end = System.currentTimeMillis();
        timeIsNearCompare = timeIsNearCompare + (end -start);
        return result;
    }
}


