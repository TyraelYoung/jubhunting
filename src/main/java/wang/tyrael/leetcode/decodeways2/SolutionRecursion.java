package wang.tyrael.leetcode.decodeways2;

public class SolutionRecursion {
    private static final int MOD = 1000000000 + 7;

    public int numDecodings(String s) {
        int result = 1;
        switch (s.length()) {
            case 1:
                char first = s.charAt(0);
                if (first == '*') {
                    result = 9;
                } else {
                    result = 1;
                }
                break;
            case 2:
                //1. 处理首位1位数
                first = s.charAt(0);
                char second = s.charAt(1);
                int resultOne;
                if (first == '*') {
                    resultOne = 9 * numDecodings(s.substring(1));
                } else {
                    resultOne = numDecodings(s.substring(1));
                }
                //2. 处理首位2位数
                //注意不要重复计算1位数
                int resultTwo;
                switch (first) {
                    case '1':
                        if (second == '*') {
                            resultTwo = 9;
                        } else {
                            resultTwo = 1;
                        }
                        break;
                    case '2':
                        if (second == '*') {
                            resultTwo = 6;
                        } else if (second > '6') {
                            resultTwo = 0;
                        } else {
                            resultTwo = 1;
                        }
                        break;
                    case '*':
                        if (second == '*') {
                            resultTwo = 15;
                        } else if (second > '6') {
                            resultTwo = 1;
                        } else {
                            resultTwo = 2;
                        }
                        break;
                    default:
                        resultTwo = 0;
                        break;
                }
                result = resultOne + resultTwo;
                break;


            default:
                //1. 处理首位1位数

                first = s.charAt(0);
                second = s.charAt(1);
                if (first == '*') {
                    resultOne = 9 * numDecodings(s.substring(1));
                } else {
                    resultOne = numDecodings(s.substring(1));
                }
                //2. 处理首位2位数
                //注意不要重复计算1位数
                switch (first) {
                    case '1':
                        if (second == '*') {
                            resultTwo = 9 * numDecodings(s.substring(2));
                        } else {
                            resultTwo = numDecodings(s.substring(2));
                        }
                        break;
                    case '2':
                        if (second == '*') {
                            resultTwo = 6 * numDecodings(s.substring(2));
                        } else {
                            if (second > '6') {
                                resultTwo = 0;
                            } else {
                                resultTwo = numDecodings(s.substring(2));
                            }
                        }
                        break;
                    case '*':
                        if (second == '*') {
                            resultTwo = 15 * numDecodings(s.substring(2));
                        } else {
                            resultTwo = 6 * numDecodings(s.substring(2));
                        }
                        break;
                    default:
                        resultTwo = 0;
                        break;
                }
                result = resultOne + resultTwo;
                break;
        }
        return result;

    }
}
