package wang.tyrael.leetcode.wordsearch2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 注意的点：
 * 1. 正方形、长方形
 * 2. 结果重复
 *
 * @author: wangchao
 */
public class Solution {
    Trie trie;
    List<String> result = new ArrayList<>();

    char[][] board;
    String[] words;
    int height, width;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        height = board.length;
        width = board[0].length;

        createTrie();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                findNext(new Coordinate(i, j), new HashSet<>(), trie.root);
            }
        }
        removeDuplicate();
        return result;
    }

    void removeDuplicate(){
        for (int i = result.size()-1; i > 0 ; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                String a = result.get(i);
                String b = result.get(j);
                if (a.equals(b)){
                    result.remove(i);
                    break;
                }
            }
        }
    }

    void findNext(Coordinate cur, Set<Coordinate> path, Node trieNode){
        //当前节点
        char value = board[cur.x][cur.y];
        Node node = trieNode.children[order(value)];
        if (node == null){
            return;
        }
        if (node.leaf != null){
            result.add(node.leaf);
        }
        //下一个节点

        //左上右下
        Coordinate left = cur.left();
        Coordinate up = cur.up();
        Coordinate right = cur.right();
        Coordinate down = cur.down();

        if(left.isValid(height, width) && !path.contains(left)){
            Set set = new HashSet(path);
            set.add(cur);
            findNext(left, set, node);
        }

        if(up.isValid(height, width) && !path.contains(up)){
            Set set = new HashSet(path);
            set.add(cur);
            findNext(up, set, node);
        }

        if(down.isValid(height, width) && !path.contains(down)){
            Set set = new HashSet(path);
            set.add(cur);
            findNext(down, set, node);
        }

        if(right.isValid(height, width) && !path.contains(right)){
            Set set = new HashSet(path);
            set.add(cur);
            findNext(right, set, node);
        }
    }

    void createTrie(){
        trie = new Trie();
        trie.create();
        for (String s:
             words) {
            trie.insert(s);
        }
    }

    class Coordinate{
        //x 行号
        //y 列号
        int x,y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         *
         * @param maxX exclude
         * @param maxY
         * @return
         */
        public boolean isValid(int maxX, int maxY){
            return x >= 0 && x < maxX && y>=0 &&y <maxY;
        }

        public Coordinate left(){
            return new Coordinate(x, y-1);
        }
        public Coordinate up(){
            return new Coordinate(x-1, y);
        }
        public Coordinate right(){
            return new Coordinate(x, y+1);
        }
        public Coordinate down(){
            return new Coordinate(x+1, y);
        }


        @Override
        public int hashCode() {
            String s = x +"," + y;
            return s.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Coordinate){
                Coordinate b = (Coordinate) obj;
                return x == b.x && y == b.y;

            }else{
                return false;
            }
        }
    }



    class Node {
        Node[] children;
        String leaf;


        /**
         * @param n 孩子容量
         */
        public Node(int n) {
            children = new Node[n];
        }
    }

    class Trie {
        Node root;

        public Node create() {
            root = new Node(26);
            return root;
        }

        public void insert(String s) {
            //逐个查找，找不到则建点
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                int index = order(s.charAt(i));
                Node child = node.children[index];
                if (child == null) {
                    child = new Node(26);
                    node.children[index] = child;
                    node = child;
                } else {
                    node = child;
                }
            }
            node.leaf = s;
        }

        public boolean search(String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                int index = order(s.charAt(0));
                Node child = node.children[index];
                if (child == null) {
                    return false;
                } else {
                    node = child;
                }
            }
            //如果该词是其他词的前缀，也不存在。
            return node.leaf != null;
        }


    }

    public static int order(char a) {
        return a - 'a';
    }

}
