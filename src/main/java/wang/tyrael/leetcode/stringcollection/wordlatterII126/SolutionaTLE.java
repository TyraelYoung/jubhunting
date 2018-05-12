package wang.tyrael.leetcode.stringcollection.wordlatterII126;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]

 ["hit","hot","lot","log","cog", cob]

 *
 * 1， 暴力 n！
 * 2，? 划分mn，搜索a*b*c(a +b+c = n)
 *
 ab -> xy;
 am -> ky;
 km -> ky

 abc -> abp -> aop -> aoc ->xyz

 abcd -> abcq -> abzq -> ayzq ->xyzq

 最长链条 2n
 */

/**
 * 构造一个图，然后深度搜索。
 */
public class SolutionaTLE {
    static class Node{
        String word;
        int index;
//        List<BinaryTreeNode> children;
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
    int endIndex =-1;
    //队列辅助，实现按层访问，宽度搜索
    Queue<Node> queue = new LinkedList<>();

    boolean flagFind = false;

    static Node LEVEL_END = new Node(-2);

    public void init(){
        endIndex =-1;
        queue = new LinkedList<>();
        flagFind = false;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        init();
        calculateGraph(wordList);
        //graph = new int[wordList.size()][wordList.size()];
        this.endWord = endWord;
        this.wordList = wordList;
        for (int i = 0; i < wordList.size(); i++) {
            if(endWord.equals(wordList.get(i))){
                endIndex = i;
            }
        }
        if(endIndex == -1){
            return new ArrayList<>();
        }

        Node root = new Node(beginWord, -1);
        //找到第一个邻居
        //初始化第一层
        for (int i = 0; i < wordList.size(); i++) {
            String b = wordList.get(i);
            if(isNear(beginWord, b)){
                Node node = new Node(b, i, root);
                queue.add(node);
            }
        }
        queue.add(LEVEL_END);
        List<Node> result = find();
        List<List<String>> resultFormat = new ArrayList<>();
        for (Node end :
                result) {
            List<String> item = new ArrayList<>();
            Node next  = end;
            while(next != null){
                item.add(0, next.word);
                next = next.parent;
            }
            resultFormat.add(item);
        }
        //转化一下
        return resultFormat;
}

    /**
     * 宽度搜索，最短路径
     * @return
     */
    public List<Node> find(){
        List<Node> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Node next = queue.poll();
            if(next.index == -2){
                if(flagFind){
                    //本层结束；
                    //如果有，则返回所有的值。
                    return result;
                }
                if(queue.isEmpty()){
                    // 返回空
                    return result;
                }else{
                    //下一层的边界
                    queue.add(LEVEL_END);
                }
            } else
            //如果没有，则查找下一层，继续
            if(next.index == endIndex){
                //找到一个
                result.add(next);
                flagFind = true;
                //继续找下一个结尾
            }else{
                //可能是常规的中间节点
                //该节点的下属加入队列
                for (int i = 0; i < wordList.size(); i++) {
                    int isNear = graph[next.index][i];
                    if(isNear == 0){
                        boolean bNear = isNear(wordList.get(next.index), wordList.get(i));
                        if(bNear){
                            graph[next.index][i] = 1;
                        }else{
                            graph[next.index][i] = -1;
                        }
                        isNear = graph[next.index][i];
                    }

                    if(isNear == 1 && !isVisited(next, i)){
                        Node child = new Node(wordList.get(i), i, next);
                        queue.add(child);
                    }
                }
            }
        }
        //没有找到
        return result;
    }

    public boolean isVisited(Node parent, int index){
        while(parent.index != -1){
            if(parent.index == index){
                return true;
            }
            parent = parent.parent;
        }
        return false;
    }

    public void calculateGraph(List<String> wordList){
        graph = new int[wordList.size()][wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            String a = wordList.get(i);
            for (int j = i+1; j < wordList.size(); j++) {
                String b = wordList.get(j);
                if(isNear(a, b)){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }else{
                    graph[i][j] = -1;
                    graph[j][i] = -1;
                }
            }
        }
    }

    public void printGraph(){
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
    public boolean isNear(String a, String b){
        int countDiff = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)){

            }else{
                countDiff++;
            }
            if (countDiff > 1){
                return false;
            }
        }
        if(countDiff == 0){
//            throw new RuntimeException("字符串相同");
            return false;
        }
        //==1
        return true;
    }
}
