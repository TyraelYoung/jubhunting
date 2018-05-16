package wang.tyrael.basic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manacher {
    final String src;

    char[] extend;
    int[] halfWidth;

    public List<String> longest = new ArrayList<>();

    public Manacher(String src) {
        this.src = src;
        extend = new char[2* src.length()+1];
        halfWidth = new int[2*src.length()+1];
    }

    public void run(){
        insertBoundary();
        computeEveryLength();
        computeLongest();
    }

    void computeLongest(){
        int max = 0;
        List<Integer> maxIndexes = new ArrayList<>();
        for (int i = 0; i < src.length()*2+1; i++) {
            if (halfWidth[i] < max){
                continue;
            }
            if (halfWidth[i] == max){
                maxIndexes.add(i);
                continue;
            }
            maxIndexes.clear();
            maxIndexes.add(i);
            max = halfWidth[i];
        }
        maxIndexes.stream().forEach(index->{
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = index - halfWidth[index] + 1; i < index + halfWidth[index]; i++) {
                if (extend[i] != '#'){
                    stringBuilder.append(extend[i]);
                }
            }
            longest.add(stringBuilder.toString());
        });
    }

    void computeEveryLength(){
        halfWidth[0] = 1;
        int rightEdge = 0, center = 0;
        for (int i = 1; i < src.length()*2+1; i++) {
            int thisHalfWidth = 0;
            if (i <= rightEdge){
                //对称位置
                thisHalfWidth = halfWidth[center-(i-center)];
                if (i + thisHalfWidth-1 < rightEdge){
                    //在已探测范围内，必然无法拓展
                    halfWidth[i] = thisHalfWidth;
                    continue;
                }
                thisHalfWidth = rightEdge - i + 1;
            }else{
                thisHalfWidth = 1;
            }
            //以i为中心扩展
            while(i + thisHalfWidth< src.length()*2+1
                    && i - thisHalfWidth >= 0
                    && extend[i + thisHalfWidth] == extend[i - thisHalfWidth]){
                thisHalfWidth++;
            }
            halfWidth[i] = thisHalfWidth;
            if (i + thisHalfWidth-1 > rightEdge){
                //探测范围已拓展
                rightEdge = i+ thisHalfWidth-1;
                center = i;
            }
        }
    }

    void insertBoundary(){
        for (int i = 0; i < src.length(); i++) {
            extend[2*i] = '#';
            extend[2*i+1] = src.charAt(i);
        }
        extend[src.length() *2] = '#';
    }
}
