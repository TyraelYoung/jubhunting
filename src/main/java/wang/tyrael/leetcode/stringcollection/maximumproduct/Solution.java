package wang.tyrael.leetcode.stringcollection.maximumproduct;

/**
 * @author: wangchao
 * 2018/5/18 0018
 */
public class Solution {
    public int maxProduct(String[] words) {
        int res = 0, n = words.length;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = 0;
            for(char c: words[i].toCharArray()){
                nums[i] |= 1 << (c - 'a');
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((nums[i] & nums[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
