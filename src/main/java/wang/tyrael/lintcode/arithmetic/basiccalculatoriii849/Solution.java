package wang.tyrael.lintcode.arithmetic.basiccalculatoriii849;

import java.util.Stack;

/**
 * The expression string contains only non-negative integers, +, -, *, / operators ,
 * open ( and closing parentheses ) and empty spaces . The integer division should
 * truncate toward zero.
 *
 * @Auther: wangchao
 * @Date: 2018/7/10 14:24
 * @Description:
 */
public class Solution {
    int indexToParse;
    String s;

    Stack<Character> stackOperator = new Stack<>();
    Stack<Long> stackOperand = new Stack<>();

    /**
     * @param s: the expression string
     * @return: the answer
     */
    public int calculate(String s) {
        this.s = s;

        // Write your code here
        while (!checkEndAndRemvoeSpace()) {
            if (isNumber()){
                long number = parseNumber();
                stackOperand.push(number);
            }else{
                char operator = parseOperator();
                switch (operator){
                    case '(':
                        stackOperator.push(operator);
                        continue;
                    case ')':
                        char leftOperator = stackOperator.peek();
                        //计算括号内所有元素
                        while (leftOperator != '(') {
                            calculateOnce();
                            leftOperator = stackOperator.peek();
                        }
                        stackOperator.pop();
                        continue;
                    default:
                        //+-*/
                        //计算左边所有高低优先级的
                        while (true){
                            if (stackOperator.isEmpty()) break;
                            leftOperator = stackOperator.peek();
                            int p = comparePriority(leftOperator, operator);
                            if (p > 0) {
                                calculateOnce();
                                continue;
                            }else{
                                break;
                            }
                        }
                        stackOperator.push(operator);
                        break;
                }
            }
        }
        //结束时，栈里还有一对，或者一个
        while (!stackOperator.isEmpty()) calculateOnce();
        return Math.toIntExact(stackOperand.pop());
    }

    void calculateOnce(){
        long rightOperand = stackOperand.pop();
        long leftOperand = stackOperand.pop();
        char oprator = stackOperator.pop();
        long result = 0;
        switch (oprator){
            case '+':
                result = leftOperand + rightOperand;
                break;
            case '-':
                result = leftOperand - rightOperand;
                break;
            case '*':
                result = leftOperand * rightOperand;
                break;
            case '/':
                result = leftOperand / rightOperand;
                break;
        }
        stackOperand.push(result);
    }

    int comparePriority(char leftOperator, char rightOperator) {
        switch (leftOperator) {
            case '(':
                return -1;
            case '*':
            case '/':
                if (rightOperator == '(') return -1;
                return 1;
            case '+':
            case '-':
                switch (rightOperator) {
                    case '*':
                    case '/':
                    case '(':
                        return -1;
                    default:
                        return 1;
                }
            default:
                throw new RuntimeException("不支持的操作符");
        }
    }

    boolean checkEndAndRemvoeSpace() {
        int end = indexToParse;
        while (end < s.length() && s.charAt(end) == ' ') end++;
        if (end < s.length()) {
            indexToParse = end;
            return false;
        }
        return true;
    }

    long parseNumber() {
        int start = indexToParse, end = indexToParse;
        while (end < s.length() && Character.isDigit(s.charAt(end))) end++;
        indexToParse = end;
        return Long.parseLong(s.substring(start, end));
    }

    char parseOperator() {
        return s.charAt(indexToParse++);
    }

    boolean isNumber(){
        return Character.isDigit(s.charAt(indexToParse));
    }
}
