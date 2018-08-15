package wang.tyrael.leetcode.binarytree.bst.uniqueii;

import wang.tyrael.basic.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangchao
 * 2018/5/7 0007
 */
public class Solution {
    Map<Point, List<TreeNode>> edgeToRoot = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        return generateChild(1, n);
    }

    public List<TreeNode> generateChild(int start, int end){
        List<TreeNode> cache = edgeToRoot.get(new Point(start, end));
        if (cache != null){
            return cache;
        }
        List<TreeNode> roots = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateChild(start, i-1);
            List<TreeNode> rights = generateChild(i+1, end);
            if (lefts.isEmpty() && rights.isEmpty()){
                TreeNode root = new TreeNode(i);
                roots.add(root);
                continue;
            }
            if (lefts.isEmpty()){
                for (TreeNode right :
                        rights) {
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    roots.add(root);
                }
                continue;
            }
            if (rights.isEmpty()){
                for (TreeNode left :
                        lefts) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    roots.add(root);
                }
                continue;
            }
            for (TreeNode left :
                    lefts) {
                for (TreeNode right :
                        rights) {
                    TreeNode root = new TreeNode(i);
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

