package wang.tyrael.leetcode.reversebits190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String bits = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(bits);
        sb.reverse();
        while(sb.length() < 32){
            sb.append(0);
        }

//        System.out.println("00111001011110000010100101000000;");
//        System.out.println(reverse);
        if(sb.charAt(0) == '0'){

        }else{
            //取反+1
            for (int i = 0; i < 32; i++) {
                if(sb.charAt(i) == '0'){
                    sb.setCharAt(i, '1');
                }else{
                    sb.setCharAt(i, '0');
                }
            }
            int flagOver = 1;
            for (int i = 31; i >= 0 ; i--) {
                if (flagOver > 0){
                    if (sb.charAt(i) == '0'){
                        sb.setCharAt(i, '1');
                        flagOver = 0;
                    }else{
                        sb.setCharAt(i, '0');
                        flagOver = 1;
                    }
                }else{
                    break;
                }
            }
           sb.insert(0, '-');
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
