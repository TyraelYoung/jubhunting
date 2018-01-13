package wang.tyrael.leetcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import wang.tyrael.Stack;

import java.util.*;

public class LongestValidParentheses32 {
    public static void main(String[] args){
        LongestValidParentheses32 l = new LongestValidParentheses32();
        int result;

        result = l.longestValidParentheses("(()");
        System.out.println("2:" + result);

        result = l.longestValidParentheses(")()())");
        System.out.println("4:" + result);
    }

    public int longestValidParentheses(String s) {
        List<Integer> breakPoints = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    breakPoints.add(i);
                }else{
                    stack.pop();
                }
            }
        }
//        while(!stack.isEmpty()){
//            breakPoints.add(stack.pop());
//        }
//        Collections.sort(breakPoints);
        breakPoints = merge(breakPoints, stack);

        int start =0;
        int end =0;
        int max =0;
        for(int i=0; i< breakPoints.size(); i++){
            end = breakPoints.get(i);
            int thisLength = end -start;
            if(thisLength > max){
                max = thisLength;
            }
            start = end+1;
        }
        end = s.length();
        int thisLength = end -start;
        if(thisLength > max){
            max = thisLength;
        }
        return max;
    }

    /**
     * 归并排序
     * @param list
     * @param stack
     * @return
     */
    public List<Integer> merge(List<Integer> list, Stack<Integer> stack){
        List<Integer> result = new LinkedList<>();
        int i = list.size()-1;
        while(i>= 0 && !stack.isEmpty()){
            int a = list.get(i);
            int b = stack.peek();
            if(a > b){
                result.add(0, a);
                i--;
            }else{
                result.add(0, stack.pop());
            }
        }
        while(i>=0){
            int a = list.get(i);
            result.add(0, a);
            i--;
        }
        while(!stack.isEmpty()){
            result.add(0, stack.pop());
        }
        return result;
    }

}
