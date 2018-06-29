package wang.tyrael.leetcode.stringcollection.wordlatter127;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * @Auther: wangchao
 * @Date: 2018/6/29 14:08
 * @Description:
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return findLadders( beginWord,  endWord, wordList);
    }

    private Set<String> wordSet;
    String endWord;

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

    public int findLadders(String beginWord, String endWord, List<String> wordList) {
        //用于缓存，防止多次比较
        wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        this.endWord = endWord;
        if (!wordSet.contains(endWord)){
            return 0;
        }

        startRoot = new TreeNode(beginWord, -1, 0);
        endRoot = new TreeNode(endWord, endIndex, 0);

        initStartQueue(beginWord);
        initEndQueue(endWord);

        countLevel = 0;
        //双端bfs，每端只要一半就可以了
        int limit = wordList.size()/2;
        if (!flagFind) {
            //long startWhile = System.currentTimeMillis();
            while (countLevel < limit +1) {
                countLevel ++;
                boolean toContinueStart = oneEndOneLevel(startQueue, startSet, startValueToNode, endSet, meetPoint);
                if (flagFind) {
                    break;
                }
                boolean toContinueEnd = oneEndOneLevel(endQueue, endSet, endValueToNode, startSet, meetPoint);
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

    public int formatResult(){
        if (flagFind) {
            List<List<String>> resultFormat = new ArrayList<>();
            for (String meet : meetPoint) {
                List<TreeNode> meetInEnd = endValueToNode.get(meet);
                List<TreeNode> meetInStart = startValueToNode.get(meet);
                return meetInEnd.get(0).level + meetInStart.get(0).level +1;
            }
        }
        return 0;

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
        startQueue.add(startRoot);
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
            //当前单词的变种是否在集合中
            String parent = next.word;

            for (int i = 0; i < parent.length(); i++) {
                StringBuilder sbParent = new StringBuilder(parent);
                for (char j = 'a'; j <= 'z' ; j++) {
                    if (j == sbParent.charAt(i)){

                    }else{
                        sbParent.setCharAt(i, j);
                        String child = sbParent.toString();
                        if (seen.contains(child)){
                            //上面层次已经包含该单词
                            continue;
                        }
                        if (!wordSet.contains(child)){
                            continue;
                        }
                        //符合要求的变种
                        TreeNode nchild = new TreeNode(child, next);
                        nchild.level = next.level +1;
                        queue.add(nchild);
                        putNode(valueToNode, nchild);
                        seenThisLevel.add(child);
                        next.children.add(nchild);

                        if (other.contains(child)) {
                            flagFind = true;
                            meetPoint.add(child);
                        }
                    }
                }
            }

        }
    }


}

class TreeNode {

    public String word;
    public int index;
    public int level =0;
    //调试使用
    public List<TreeNode> children = new ArrayList<>();
    public TreeNode parent;

    public TreeNode(int index) {
        this.index = index;
    }

    public TreeNode(String word, int index) {
        this.word = word;
        this.index = index;
    }

    public TreeNode(String word, int index, int level) {
        this.word = word;
        this.index = index;
        this.level = level;
    }

    public TreeNode(String word, int index, TreeNode parent) {
        this.word = word;
        this.index = index;
        this.parent = parent;
    }

    public TreeNode(String child, TreeNode next) {
        this.word = child;
        this.parent = next;
    }

    @Override
    public String toString() {
        return word;
    }
}
