package wang.tyrael.leetcode.string.decodeways2;

public class Solution {
    private static final int MOD = 1000000000 + 7;

    public int numDecodings(String s) {
        long fn_1 = 0, fn_2 = 0, fn;

        long f1 = 0;
        long f2 = 0;
        f1 = f1(s.substring(s.length() - 1));
        if (s.length() == 1) {
            return (int) f1;
        }
        f2 = f2(s.substring(s.length() - 2));
        if (s.length() == 2) {
            return (int) f2;
        }

        fn_1 = f2;
        fn_2 = f1;

        //从右向左，从1开始
        //长度3-s.length()
        for (int i = s.length() - 3; i >= 0; i--) {
            char cn = s.charAt(i);
            char cn_1 = s.charAt(i + 1);
            long one = one(cn);
            long two = two(cn, cn_1);

            fn = one * fn_1 % MOD + two * fn_2 % MOD;
            fn = fn % MOD;

            fn_2 = fn_1;
            fn_1 = fn;
        }
        return (int) fn_1;
    }

    private long f1(String s) {
        char first = s.charAt(0);
        return one(first);
    }

    private long f2(String s) {
        char first = s.charAt(0);
        char second = s.charAt(1);
        //1. 处理首位1位数
        long resultOne = one(first) * one(second);
        //2. 处理首位2位数
        //注意不要重复计算1位数
        long resultTwo = two(first, second);
        return resultOne + resultTwo;
    }

    public static long one(char first) {
        long resultOne;
        if (first == '*') {
            resultOne = 9;
        } else if(first == '0'){
            resultOne = 0;
        } else{
            resultOne = 1;
        }
        return resultOne;
    }

    /**
     * 两位组合
     *
     * @return
     */
    public static long two(char first, char second) {
        long resultTwo;
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
        return resultTwo;
    }
}
