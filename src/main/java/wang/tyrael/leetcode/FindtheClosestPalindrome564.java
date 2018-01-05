package wang.tyrael.leetcode;

public class FindtheClosestPalindrome564 {
    public static void main(String[] args){
        String n = "123";
        String result = new FindtheClosestPalindrome564().nearestPalindromic(n);
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("1");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("1221");
        System.out.println(result);

        result = new FindtheClosestPalindrome564().nearestPalindromic("1213");
        System.out.println(result);
    }


    public String nearestPalindromic(String n) {
        char[] temp = new char[n.length()];
        //对半查看
        for(int i=0; i <= (n.length() -1)/2; i++){
            char x1 = n.charAt(i);
            char x2 = n.charAt(n.length()-1-i);
            int x1i = Integer.parseInt(new String(new char[]{x1}));
            int x2i = Integer.parseInt(new String(new char[]{x2}));
//            if(x1i > x2i){
//                temp[i] = x2;
//                temp[n.length()-1-i] = x2;
//            }else{
                temp[i] = x1;
                temp[n.length()-1-i] = x1;
//            }
        }
        String result = new String(temp);
        if(n.equals(result)){
            if(n.length() %2 ==0){
                int index = (n.length() -1)/2;
                temp[index] --;
                temp[index+1] --;
            }else{
                int index = (n.length() -1)/2;
                temp[index] --;
            }
        }
        result = new String(temp);
        return result;
    }
}
