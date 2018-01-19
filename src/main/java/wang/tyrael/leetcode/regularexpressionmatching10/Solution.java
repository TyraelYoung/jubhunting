package wang.tyrael.leetcode.regularexpressionmatching10;

public class Solution {
    public boolean isMatch(String aa, String a) {
        boolean result;
        switch (a.length()) {
            case 0:
                result =  aa.length() == 0;
                break;
            case 1:
                if (a.equals(".")) {
                    result = aa.length() == 1;
                } else {
                    result = aa.equals(a);
                }
                break;
            case 2:
                char zeroA = a.charAt(0);
                char oneA = a.charAt(1);
                if (oneA == '*') {
                    switch (aa.length()) {
                        case 0:
                            result = true;
                            break;
                        case 1:
                            if (zeroA == '.') {
                                result = true;
                            } else {
                                char zeroAA = aa.charAt(0);
                                if (zeroA == zeroAA) {
                                    result = true;
                                } else {
                                    result = false;
                                }
                            }
                            break;
                        case 2:
                        default:
                            if (zeroA == '.') {
                                result = true;
                            } else {
                                 result = isOneChar(aa, zeroA);
                            }
                            break;
                    }
                } else {
                    //zero 也不是*
                    if (aa.length() == 2) {
                        if (zeroA == '.') {
                            result = isMatch(aa.substring(1), a.substring(1));
                        } else {
                            char zeroAA = aa.charAt(0);
                            if (zeroA == zeroAA) {
                                result = isMatch(aa.substring(1), a.substring(1));
                            } else {
                                result = false;
                            }
                        }
                    } else {
                        result = false;
                    }
                }
                break;
            default:
                zeroA = a.charAt(0);
                oneA = a.charAt(1);

                if(aa.length() == 0){
                    if(oneA == '*'){
                        result =  isMatch(aa, a.substring(2));
                    }else{
                        result = false;
                    }
                    break;
                }


                if (oneA == '*') {
                    String nextA = a.substring(2);
                    if (zeroA == '.') {
                        //至少留一个字符
                        for (int i = 0; i < aa.length(); i++) {
                            String nextAA = aa.substring(i);
                            if(isMatch(nextAA, nextA)){
                                result = true;
                                break;
                            }
                        }
                        result = false;
                    }else{
                        if(isMatch(aa, nextA)){
                            result = true;
                            break;
                        }
                        if(aa.length() < 2){
                            result = false;
                            break;
                        }
                        for (int i = 0; i < aa.length(); i++) {
                            char current = aa.charAt(i);
                            if(current == zeroA){
                                String nextAA = aa.substring(i);
                                if(isMatch(nextAA, nextA)){
                                    result = true;
                                    break;
                                }
//                                else{
//                                nextAA 还可以更短
//                                    continue;
//                                }
                            }else{
                                //第一个不等于zeroA的字符
                                String nextAA = aa.substring(i);
                                result = isMatch(nextAA, nextA);
                                break;
                            }
                        }
                        result = false;
                        break;
                    }
                    break;
                } else {
                    if (zeroA == '.') {
//                        if(aa.length() < 2){
//                            result = false;
//                        }
                        result = isMatch(aa.substring(1), a.substring(1));
                    } else {
                        char zeroAA = aa.charAt(0);
                        if (zeroA == zeroAA) {
                            result = isMatch(aa.substring(1), a.substring(1));
                        } else {
                            result = false;
                        }
                    }
                    break;
                }
        }
        if(aa.length() <=3 && a.length() <= 4){
            System.out.println("aa:" + aa + ",a:" + a + ",result:" + result  );
        }

        return result;

    }

    private boolean isOneChar(String s, char c){
        for (int i = 0; i < s.length(); i++) {
            if(c == s.charAt(i)){

            }else{
                return false;
            }
        }
        return true;
    }
}
