package wang.tyrael.leetcode;
//Given an integer n, find the closest integer (not including itself), which is a palindrome.
//
//        The 'closest' is defined as absolute difference minimized between two integers.
//
//        Example 1:
//        Input: "123"
//        Output: "121"
//        Note:
//        The input n is a positive integer represented by string, whose length will not exceed 18.
//        If there is a tie, return the smaller one as answer.
public class FindtheClosestPalindrome564 {
    public static void main(String[] args){

        String result = new FindtheClosestPalindrome564().nearestPalindromic("123");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("1");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("1221");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("1213");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("10");
        System.out.println(result);



        result = new FindtheClosestPalindrome564().nearestPalindromic("11011");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("101");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("807045053224792883");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("99");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("1283");
        //1331
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("11");
        System.out.println(result);
    }

    /**
     * 暴力,超时了
     * @param n
     * @return
     */
    public String nearestPalindromic2(String n) {
        long iValue = Long.parseLong(n);
        long step = 0;
        while(true){
            step ++;
            long down = iValue -step;
            String sDown = Long.toString(down);
            if(sDown.equals(new StringBuilder(sDown).reverse().toString())){
                return sDown;
            }
            long up = iValue + step;
            String sUp = Long.toString(up);
            if(sUp.equals(new StringBuilder(sUp).reverse().toString())){
                return sUp;
            }
        }
    }

    /**
     * 分析回文数
     * 找到三个最接近的数，选出符合要求的
     * @param n
     * @return
     */
    public String nearestPalindromic(String n) {
        if(n.length() == 1){
            return Long.toString(Long.parseLong(n) -1);
        }


        //少一位，最接近值
        long iDown = (long) (Math.pow(10, n.length()-1) -1);
        //多一位，最接近值
        long iUp =  (long) (Math.pow(10, n.length()) +1);

        long resultMax = 0;
        long resultMid = 0;
        long resultMin = 0;

        //同位
        if(n.length() %2 ==0){
            //偶数位
            //前半部分
            String high = n.substring(0, n.length()/2);
            String sResultMid = high + new StringBuilder(high).reverse().toString();
            resultMid = Long.parseLong(sResultMid);

            long half = Long.parseLong(high) +1;
            resultMax = getFull(half);

            half = Long.parseLong(high) -1;
            resultMin = getFull(half);
        }else{
            String high = n.substring(0, n.length()/2 + 1);
            resultMid = getFullOdd(high);

            long half = Long.parseLong(high) +1;
            resultMax = getFullOdd(half);

            half = Long.parseLong(high) -1;
            resultMin = getFullOdd(half);
        }
        return getClosest(Long.parseLong(n), new long[]{iDown, iUp, resultMax, resultMid, resultMin});
    }

    private String getClosest(long standard, long[] values){
        long tempDiff = Long.MAX_VALUE;
        long candidate = 0;
        for (long value : values){
            long diff = Math.abs(value - standard);
            if(diff == 0){
                continue;
            }
            if(diff < tempDiff){
                tempDiff = diff;
                candidate = value;
            }else if(diff == tempDiff){
                if(value < candidate){
                    tempDiff = diff;
                    candidate = value;
                }
            }
        }
        return Long.toString(candidate);
    }

    private long getFull(long half){
        String high = Long.toString(half);
        String sResultMid = high + new StringBuilder(high).reverse().toString();
        return Long.parseLong(sResultMid);
    }

    private long getFullOdd(String half){
        String high = half;
        String sResultMid = high + new StringBuilder(high).reverse().toString().substring(1);
        return Long.parseLong(sResultMid);
    }

    private long getFullOdd(long half){
        String high = Long.toString(half);
        String sResultMid = high + new StringBuilder(high).reverse().toString().substring(1);
        return Long.parseLong(sResultMid);
    }


}
