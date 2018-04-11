package wang.tyrael.leetcode.countRepetitions;

public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1 == 0){
            return 0;
        }
        int index2 = 0;
        int countM = 0;
        //遍历1
        int length1 = s1.length() * n1;
        for (int i = 0; i < length1; ) {
            char x1 = s1.charAt(i % s1.length());
            char x2 = s2.charAt(index2 % s2.length());
            if(x1 == x2){
                index2++;
                i++;
            }else{
                i++;
            }
            if(index2 == n2){
                countM++;
                index2 =0;
            }
        }
        return countM /n2;
    }
}
