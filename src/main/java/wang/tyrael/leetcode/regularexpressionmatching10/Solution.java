package wang.tyrael.leetcode.regularexpressionmatching10;

public class Solution {
    public boolean isMatch(String aa, String a) {
        if(a.length() == 1){
            if(a.equals(".")){
                return aa.length() == 1;
            }else{
                return aa.equals(a);
            }
        }
        if(a.length() == 2){
            char zeroA = a.charAt(0);
            char oneA = a.charAt(1);
            if(oneA == '*'){

            }else {
                //zero 也不是*
                if(aa.length() == 2){
                    if(zeroA == '.'){
                        return isMatch(aa.substring(1), a.substring(1));
                    }else{
                        
                    }

                }else{
                    return false;
                }


            }
        }


        return aa.equals(a);
    }
}
