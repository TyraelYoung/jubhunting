package wang.tyrael.leetcode.geometry.skyline218;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SolutionOld {
    class Event {
        static final int TYPE_START = 0;
        static final int TYPE_END = 1;
        //每个事件点包含完整的信息
        int start, end, type, height;

        public Event(int start, int end, int type, int height) {
            this.start = start;
            this.end = end;
            this.type = type;
            this.height = height;
        }

        /**
         * @return 事件发生的坐标
         */
        public int getHappenPoint() {
            if (type == Event.TYPE_START) return start;
            else return end;
        }
    }
    //高度生命长度，动态调整
    TreeMap<Integer, Integer> livingHeight = new TreeMap<>((o1, o2) -> o1 - o2);
    //所有的事件点
    PriorityQueue<Event> comingEventsQueue = new PriorityQueue<>((o1, o2) -> {
        int dif = o1.getHappenPoint() - o2.getHappenPoint();
        if (dif == 0) {
            if (o1.type == o2.type) return o1.height - o2.height; //高度按从高到低排列
            else return o1.type == Event.TYPE_END? -1: 1;//按常规习惯，end排前面,至少有一个是end
        } else {
            return dif;
        }
    });

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        //livingHeight.put(0, Integer.MAX_VALUE);
        for (int i = 0; i < buildings.length; i++) {
            int[] current = buildings[i];
            comingEventsQueue.add(new Event(current[0], current[1], Event.TYPE_START, current[2]));
            comingEventsQueue.add(new Event(current[0],current[1], Event.TYPE_END, current[2]));
        }
        int heightCurrent = 0;
        Event lastDownEvent = null;
        while (!comingEventsQueue.isEmpty()) {
            Event event = comingEventsQueue.poll();
            //把同一个事件点的,同类型，事件都取出来。
            //前面是按高度排序的，第一个是最高的
            List<Event> happenHereOther = new ArrayList<>();
            while(!comingEventsQueue.isEmpty()
                    && comingEventsQueue.peek().type == event.type
                    && comingEventsQueue.peek().getHappenPoint() == event.getHappenPoint()){
                happenHereOther.add(comingEventsQueue.poll());
            }

            switch (event.type) {
                case Event.TYPE_START://开始点只需要要考虑高度上升
                    //维持高度表，所有的都加进去，因为不知道哪个点会存续到最后
                    int end = livingHeight.getOrDefault(event.height, -1);
                    if (end < event.end) livingHeight.put(event.height, event.end);//以前没有，或者以前比较短，续命
                    for (Event eventStart : happenHereOther) {
                         end = livingHeight.getOrDefault(eventStart.height, -1);
                        if (end < eventStart.end) livingHeight.put(eventStart.height, eventStart.end);
                    }
                    //高度表不影响本次判断；考察是否发生了上升，只需要考虑最高的点。
                    if (event.height <= heightCurrent) continue;
                    //本次发生了上升
                    heightCurrent = event.height;
                        //如果上次下降的点，恰好和这次重合
                    if (lastDownEvent!= null && lastDownEvent.getHappenPoint() == event.getHappenPoint()){
                        //移除
                        result.remove(result.size()-1);
                        if(lastDownEvent.height != event.height){
                            //添加本次上升的点
                            result.add(new int[]{event.getHappenPoint(), heightCurrent});
                        }
                    }else{
                        //添加本次上升的点
                        result.add(new int[]{event.getHappenPoint(), heightCurrent});
                    }
                    break;
                case Event.TYPE_END://结束点只需要考虑高度下降。注意紧贴着的开始点。
                    //为了获取下一个高度，把当前的点的结束的高度都移除掉
                    for (Event eventEnd : happenHereOther) {
                        //该点的高度，可能被续命了，不能移除
                        //不可能为空
                        int endX = livingHeight.getOrDefault(eventEnd.height, -1);
                        if(endX == eventEnd.getHappenPoint()) livingHeight.remove(eventEnd.height);//真的终结了
                    }
                    //剩下的最高的，就是下一个高度
                    //再来考虑天际线有没有下降,只需要处理最高的点，其他点都没有用。
                    int end2 = livingHeight.getOrDefault(event.height, -1);
                    //-1表示在上面循环移除了
                    if (end2 != -1 && end2 != event.getHappenPoint()) continue;
                        //真的终结了
                    livingHeight.remove(event.height);
                    if (event.height == heightCurrent) {
                        //天际线发生下降
                        //剩余的最高点
                        if (livingHeight.isEmpty()) heightCurrent = 0;
                        else heightCurrent = livingHeight.firstKey();
                        result.add(new int[]{event.getHappenPoint(), heightCurrent});
                        lastDownEvent = event;
                    }
                    //还没终结,heightToEnd不用处理,result不用处理
                    break;
            }
        }
        return result;
    }
}
