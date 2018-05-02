package wang.tyrael.leetcode.jump.frog403;

import java.util.*;

public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 0){
            return false;
        }
        if (stones[0] != 0){
            return false;
        }
        Map<Integer, Set<Integer>> speed = new HashMap<>();
        //for 0
        Set<Integer> speed0 = new HashSet<>();
        speed0.add(0);
        speed.put(0, speed0);
        for (int i = 1; i < stones.length; i++) {
            speed.put(stones[i], new HashSet<>());
        }

        for (int i = 0; i < stones.length-1; i++) {
            Set<Integer> thisSpeeds = speed.get(stones[i]);
            for (int thisSpeed :
                    thisSpeeds) {
                if (thisSpeed -1 > 0){
                    Set nextSpeeds = speed.get(stones[i] + thisSpeed -1);
                    if (nextSpeeds != null){
                        nextSpeeds.add(thisSpeed-1);
                    }
                }
                if (thisSpeed > 0 ){
                    Set nextSpeeds = speed.get(stones[i] + thisSpeed);
                    if (nextSpeeds != null){
                        nextSpeeds.add(thisSpeed);
                    }

                }

                    Set nextSpeeds = speed.get(stones[i] + thisSpeed + 1);
                    if (nextSpeeds != null){
                        nextSpeeds.add(thisSpeed + 1);
                    }


            }
        }

        Set nextSpeeds = speed.get(stones[stones.length-1]);
        return !nextSpeeds.isEmpty();
    }
}
