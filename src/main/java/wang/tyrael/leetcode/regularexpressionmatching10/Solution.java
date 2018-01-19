package wang.tyrael.leetcode.regularexpressionmatching10;

public class Solution {
    public boolean isMatch(String aa, String a) {
        boolean result;
        returnResult:
        switch (a.length()) {
            case 0:
                result = aa.length() == 0;
                break returnResult;
            case 1:
                if (a.equals(".")) {
                    result = aa.length() == 1;
                } else {
                    result = aa.equals(a);
                }
                break returnResult;
            case 2:
            default:
                char zeroA = a.charAt(0);
                char oneA = a.charAt(1);

                if(aa.length() == 0){
                    if(oneA == '*'){
                        result =  isMatch(aa, a.substring(2));
                    }else{
                        result = false;
                    }
                    break returnResult;
                }

                if (oneA == '*') {
                    // 需要同时处理两个字符
                    String nextA = a.substring(2);
                    if (zeroA == '.') {
                        for (int i = 0; i <= aa.length(); i++) {
                            String nextAA = aa.substring(i);
                            if(isMatch(nextAA, nextA)){
                                result = true;
                                break returnResult;
                            }
                        }
                    }else{
                        for (int i = 0; i <= aa.length(); i++) {
                            String nextAA = aa.substring(i);
                            if(isMatch(nextAA, nextA)){
                                result = true;
                                break returnResult;
                            }
                            if(i == aa.length()){
                                //没有字符可去了，不能再继续尝试了
                                result = false;
                                break returnResult;
                            }
                            //尝试再去掉一个字符
                            char current = aa.charAt(i);
                            if(current == zeroA){
                                //下次循环去掉一个字符
                                continue;
                            }else{
                                //第一个不等于zeroA的字符
                                //不能再继续尝试了
                                result = false;
                                break returnResult;
                            }
                        }
                    }
                    result = false;
                    break returnResult;
                } else {
                    //只需要处理一个字符
                    char zeroAA = aa.charAt(0);
                    if (zeroA == '.' || zeroA == zeroAA) {
                        result = isMatch(aa.substring(1), a.substring(1));
                    } else {
                        result = false;
                    }
                    break returnResult;
                }
        }
        

//        if(aa.length() <=3 && a.length() <= 4){
//            System.out.println("aa:" + aa + ",a:" + a + ",result:" + result  );
//        }

        return result;

    }
}
