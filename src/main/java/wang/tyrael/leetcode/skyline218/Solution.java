package wang.tyrael.leetcode.skyline218;

import java.util.*;

public class Solution {
    class Event {
        static final int TYPE_START = 0;
        static final int TYPE_END = 1;

        int start;
        int end;
        int type;
        int height;

        public Event(int start, int end, int type, int height) {
            this.start = start;
            this.end = end;
            this.type = type;
            this.height = height;
        }

        /**
         * 事件发生的坐标
         * @return
         */
        public int getHappenPoint(){
            if (type == Event.TYPE_START){
                return start;
            }else{
                return end;
            }
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
            int dif = o1.getHappenPoint() - o2.getHappenPoint();
            if (dif > 0) {
                return 1;
            } else if (dif == 0) {
                //按常规习惯，end排前面
                if(o1.type == o2.type){
                    //高度按从高到低排列
                    int heightDif = o1.height - o2.height;
                    if(heightDif < 0){
                        return 1;
                    }else if(heightDif > 0){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{
                    if(o1.type == Event.TYPE_END){
                        return -1;
                    }
                    if(o2.type == Event.TYPE_END){
                        return -1;
                    }
                }
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
        Event lastEvent = null;
        while (!queue.isEmpty()) {
            Event event = queue.poll();
            //System.out.println(event.coordinate);
            switch (event.type) {
                case Event.TYPE_START:
                    if (event.height > heightCurrent){
                        if(lastEvent.){

                        }

                        heightCurrent = event.height;
                        result.add(new int[]{event.coordinate, heightCurrent});
                    }
                    int end = heightToEnd.getOrDefault(event.height, -1);
                    if (end < event.other){
                        //续命
                        heightToEnd.put(event.height, event.other);
                    }
                    break;
                case Event.TYPE_END:
                    //把同一个事件点的事件都取出来。


                    int end2 = heightToEnd.getOrDefault(event.height, -1);
                    if(end2 == -1){
                        //这里要注意重复的点，对应的height上次已经删除了
                        //heightToEnd不用处理
                        //result不用处理
                    } else if(end2 == event.coordinate){
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
            lastEvent = event;
        }

        return result;
    }
}
