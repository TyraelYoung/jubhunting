package wang.tyrael.leetcode.array.skyline218;

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
         *
         * @return
         */
        public int getHappenPoint() {
            if (type == Event.TYPE_START) {
                return start;
            } else {
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
                if (o1.type == o2.type) {
                    //高度按从高到低排列
                    int heightDif = o1.height - o2.height;
                    if (heightDif < 0) {
                        return 1;
                    } else if (heightDif > 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    //按常规习惯，end排前面
                    if (o1.type == Event.TYPE_END) {
                        return -1;
                    }
                    if (o2.type == Event.TYPE_END) {
                        return 1;
                    }
                    throw new RuntimeException();
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
            queue.add(new Event(current[0],current[1], Event.TYPE_END, current[2]));
        }
        int heightCurrent = 0;
        Event lastDownEvent = null;
        while (!queue.isEmpty()) {
            Event event = queue.poll();
            //System.out.println(event.coordinate);
            //把同一个事件点的,同类型，事件都取出来。
            //前面是按高度排序的，第一个是最高的
            List<Event> happenHereOther = new ArrayList<>();
            while(!queue.isEmpty()
                    && queue.peek().type == event.type
                    && queue.peek().getHappenPoint() == event.getHappenPoint()){
                happenHereOther.add(queue.poll());
            }

            switch (event.type) {
                case Event.TYPE_START:
                    //维持高度表，所有的都加进去，因为不知道哪个点会存续到最后
                    int end = heightToEnd.getOrDefault(event.height, -1);
                    if (end < event.end) {
                        //以前没有，或者以前比较短
                        //续命
                        heightToEnd.put(event.height, event.end);
                    }
                    for (Event eventStart :
                            happenHereOther) {
                         end = heightToEnd.getOrDefault(eventStart.height, -1);
                        if (end < eventStart.end) {
                            //以前没有，或者以前比较短
                            //续命
                            heightToEnd.put(eventStart.height, eventStart.end);
                        }
                    }
                    //高度表不影响本次判断
                    //考察是否发生了上升，只需要考虑最高的点。
                    if (event.height > heightCurrent) {
                        //如果上次下降的点，恰好和这次重合
                        if (lastDownEvent!= null
                                && lastDownEvent.getHappenPoint() == event.getHappenPoint()){
                            //移除
                            result.remove(result.size()-1);
                            heightCurrent = event.height;
                            if(lastDownEvent.height != event.height){
                                //添加本次上升的点

                                result.add(new int[]{event.getHappenPoint(), heightCurrent});
                            }
                        }else{
                            //添加本次上升的点
                            heightCurrent = event.height;
                            result.add(new int[]{event.getHappenPoint(), heightCurrent});
                        }
                    }
                    break;
                case Event.TYPE_END:
                    //为了获取下一个高度，把当前的点的高度都移除掉
                    for (Event eventEnd :
                            happenHereOther) {
                        //该点的高度，可能被续命了，不能移除
                        //不可能为空
                        int endX = heightToEnd.getOrDefault(eventEnd.height, -1);
                        if(endX == eventEnd.getHappenPoint()){
                            //真的终结了
                            heightToEnd.remove(eventEnd.height);
                        }
                    }
                    //剩下的最高的，就是下一个高度

                    //再来考虑天际线有没有下降,只需要处理最高的点，其他点都没有用。
                    int end2 = heightToEnd.getOrDefault(event.height, -1);
                    //-1表示在上面循环移除了
                    if (end2==-1 || end2 == event.getHappenPoint()) {
                        //真的终结了
                        heightToEnd.remove(event.height);
                        if (event.height == heightCurrent) {
                            //天际线发生下降
                            //剩余的最高点
                            if (heightToEnd.isEmpty()) {
                                heightCurrent = 0;
                            } else {
                                heightCurrent = heightToEnd.firstKey();
                            }
                            result.add(new int[]{event.getHappenPoint(), heightCurrent});
                            lastDownEvent = event;
                        }
                    } else {
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
