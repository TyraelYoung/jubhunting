package wang.tyrael.leetcode.bst.uniqueii;

import wang.tyrael.basic.BinaryTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangchao
 * 2018/5/7 0007
 */
public class Solution {
    Map<Point, List<BinaryTreeNode>> edgeToRoot = new HashMap<>();

    public List<BinaryTreeNode> generateTrees(int n) {
        return generateChild(1, n);
    }

    public List<BinaryTreeNode> generateChild(int start, int end){
        List<BinaryTreeNode> cache = edgeToRoot.get(new Point(start, end));
        if (cache != null){
            return cache;
        }
        List<BinaryTreeNode> roots = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<BinaryTreeNode> lefts = generateChild(start, i-1);
            List<BinaryTreeNode> rights = generateChild(i+1, end);
            if (lefts.isEmpty() && rights.isEmpty()){
                BinaryTreeNode root = new BinaryTreeNode(i);
                roots.add(root);
                continue;
            }
            if (lefts.isEmpty()){
                for (BinaryTreeNode right :
                        rights) {
                    BinaryTreeNode root = new BinaryTreeNode(i);
                    root.right = right;
                    roots.add(root);
                }
                continue;
            }
            if (rights.isEmpty()){
                for (BinaryTreeNode left :
                        lefts) {
                    BinaryTreeNode root = new BinaryTreeNode(i);
                    root.left = left;
                    roots.add(root);
                }
                continue;
            }
            for (BinaryTreeNode left :
                    lefts) {
                for (BinaryTreeNode right :
                        rights) {
                    BinaryTreeNode root = new BinaryTreeNode(i);
                    root.left = left;
                    root.right = right;
                    roots.add(root);
                }
            }

        }
        return roots;
    }
}

/**
 * @author: wangchao
 * 2018/4/17 0017
 */
 class Point {
    public static List<Point> toList(Point[] points){
        List<Point> list = new ArrayList<>();
        for (Point p :
                points) {
            list.add(p);
        }
        return list;
    }


    public int x;
    public int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point){
            Point b = (Point) obj;
            return x == b.x && y == b.y;
        }else{
            return false;
        }
    }
}

