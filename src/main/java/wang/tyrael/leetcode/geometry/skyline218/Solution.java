package wang.tyrael.leetcode.geometry.skyline218;

import java.util.*;

public class Solution {
    class Event {
        static final int TYPE_START = 0;
        static final int TYPE_END = 1;

        int start, end, type, height;

        public Event(int start, int end, int type, int height) {
            this.start = start;
            this.end = end;
            this.type = type;
            this.height = height;
        }

        /**
         * 事件发生的坐标
         *
         * @return
         */
        public int getHappenPoint() {
            if (type == Event.TYPE_START)  return start;
            else return end;
        }
    }

    TreeMap<Integer, Integer> heightToEnd = new TreeMap<>((o1, o2) -> o2 - o1);
    PriorityQueue<Event> queue = new PriorityQueue<>((o1, o2) -> o1.getHappenPoint() - o2.getHappenPoint());

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] current = buildings[i];
            queue.add(new Event(current[0], current[1], Event.TYPE_START, current[2]));
            queue.add(new Event(current[0], current[1], Event.TYPE_END, current[2]));
        }
        int heightLast = 0;
        //每次处理一个坐标点的所有事件
        while (!queue.isEmpty()) {
            Event eventPeek = queue.peek();
            //把同一个事件点的,事件都取出来。
            //前面是按高度排序的，第一个是最高的
            List<Event> happenHereStart = new ArrayList<>();
            List<Event> happenHereEnd = new ArrayList<>();
            while (!queue.isEmpty() && queue.peek().getHappenPoint() == eventPeek.getHappenPoint()) {
                Event eventPoll = queue.poll();
                if (eventPoll.type == Event.TYPE_START) happenHereStart.add(eventPoll);
                else happenHereEnd.add(eventPoll);
            }
            //处理高度表
            //处理结束事件的影响
            for(Event event: happenHereEnd){
                //该点的高度，可能被续命了，不能移除
                //可能为空, 如果有相同的数据
                int endX = heightToEnd.getOrDefault(event.height, -1);
                //真的终结了
                if (endX == event.getHappenPoint()) heightToEnd.remove(event.height);
            }
            //处理开始事件的影响
            for (Event event: happenHereStart){
                int end = heightToEnd.getOrDefault(event.height, -1);
                //以前没有，或者以前比较短
                if (end < event.end) heightToEnd.put(event.height, event.end);
            }
            int heightNow = 0;
            if (!heightToEnd.isEmpty()) heightNow = heightToEnd.firstKey();
            if (heightLast != heightNow) result.add(new int[]{eventPeek.getHappenPoint(), heightNow});
            heightLast = heightNow;
        }
        return result;
    }
}
