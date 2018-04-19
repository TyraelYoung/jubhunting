package wang.tyrael.leetcode.skyline218;

import java.util.*;

public class Solution {
    class Event {
        static final int TYPE_START = 0;
        static final int TYPE_END = 1;

        int coordinate;
        int other;
        int type;
        int height;

        public Event(int coordinate, int type, int height) {
            this.coordinate = coordinate;
            this.type = type;
            this.height = height;
        }

        public Event(int coordinate, int other, int type, int height) {
            this.coordinate = coordinate;
            this.other = other;
            this.type = type;
            this.height = height;
        }
    }

    TreeMap<Integer, Integer> heightToEnd = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int dif = o1 - o2;
            if (dif > 0) {
                return -1;
            } else if (dif == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    });
    PriorityQueue<Event> queue = new PriorityQueue<>(new Comparator<Event>() {
        @Override
        public int compare(Event o1, Event o2) {
            int dif = o1.coordinate - o2.coordinate;
            if (dif > 0) {
                return 1;
            } else if (dif == 0) {
                return 0;
            } else {
                return -1;
            }
        }
    });

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        //heightToEnd.put(0, Integer.MAX_VALUE);
        for (int i = 0; i < buildings.length; i++) {
            int[] current = buildings[i];
            queue.add(new Event(current[0], current[1], Event.TYPE_START, current[2]));
            queue.add(new Event(current[1], Event.TYPE_END, current[2]));
        }
        int heightCurrent = 0;
        while (!queue.isEmpty()) {
            Event event = queue.poll();
            //System.out.println(event.coordinate);
            switch (event.type) {
                case Event.TYPE_START:
                    if (event.height > heightCurrent){
                        heightCurrent = event.height;
                        result.add(new int[]{event.coordinate, heightCurrent});
                    }
                    int end = heightToEnd.getOrDefault(event.height, 0);
                    if (end < event.coordinate){
                        //续命
                        heightToEnd.put(event.height, event.coordinate);
                    }
                    break;
                case Event.TYPE_END:
                    int end2 = heightToEnd.get(event.height);
                    if(end2 == event.coordinate){
                        //真的终结了
                        heightToEnd.remove(event.height);
                        if(event.height == heightCurrent){
                            //天际线发生下降

                            //剩余的最高点
                            if(heightToEnd.isEmpty()){
                                heightCurrent = 0;
                            }else{
                                heightCurrent = heightToEnd.firstKey();
                            }

                            result.add(new int[]{event.coordinate, heightCurrent});
                        }
                    }else{
                        //还没终结
                        //heightToEnd不用处理
                        //result不用处理
                    }
                    break;
            }
        }

        return result;
    }
}
