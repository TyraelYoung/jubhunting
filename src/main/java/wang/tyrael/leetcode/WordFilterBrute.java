package wang.tyrael.leetcode;

public class WordFilterBrute {
    private String[] words;

    public WordFilterBrute(String[] words) {
        this.words = words;
    }

    public int f(String prefix, String suffix) {
        for(int i= words.length-1; i>=0; i--){
            String word = words[i];
            if(word.startsWith(prefix) && word.endsWith(suffix)){
                return i;
            }
        }
        return -1;
    }
}
