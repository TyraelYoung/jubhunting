package wang.tyrael.leetcode.array.containsduplicate3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author: wangchao
 * 2018/6/11 0011
 */
public class Solution {
//    Given an array of integers, find out whether there are two distinct indices i and j move the array
// such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
//
//    Example 1:
//
//    Input: nums = [1,2,3,1], k = 3, t = 0
//    Output: true
//    Example 2:
//
//    Input: nums = [1,0,1,1], k = 1, t = 2
//    Output: true
//    Example 3:
//
//    Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//    Output: false
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Window window = new Window(k+1,t);
        for (int i = 0; i < nums.length; i++) {
            if (window.checkAndMove(nums[i])){
                return true;
            }
        }
        return false;
    }

    public class Node implements Comparable<Node>{
        final long value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            long diff = value - o.value;
            if (diff == 0) return 0;
            return diff<0?-1:1;
        }
    }

    public class Window{
        final int capacity;
        final int duplicateThreshold;

        TreeSet<Node> treeSet = new TreeSet<>();
        Queue<Node> queue = new LinkedList<>();
        int size;

        public Window(int capacity, int duplicateThreshold) {
            this.capacity = capacity;
            this.duplicateThreshold = duplicateThreshold;
        }

        public boolean checkAndMove(int value){
            if (size == capacity){
                Node out = queue.remove();
                treeSet.remove(out);
            }else {
                size++;
            }
            boolean isDuplicate = isDupilcate(value);
            Node in = new Node(value);
            queue.add(in);
            treeSet.add(in);
            return isDuplicate;
        }

        public boolean isDupilcate(int value){
            if(size <=0){
                return false;
            }

            Node lowNode = treeSet.floor(new Node(value));
            if (lowNode != null && value - lowNode.value <= duplicateThreshold){
                return true;
            }
            Node highNode = treeSet.ceiling(new Node(value));
            if (highNode != null && highNode.value - value <= duplicateThreshold){
                return true;
            }
            return false;
        }
    }
}
