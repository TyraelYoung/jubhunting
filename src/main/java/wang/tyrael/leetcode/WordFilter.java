package wang.tyrael.leetcode;


//Given many words, words[i] has weight i.
//
//        Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.
//
//        Examples:
//        Input:
//        WordFilter(["apple"])
//        WordFilter.f("a", "e") // returns 0
//        WordFilter.f("b", "") // returns -1
//        Note:
//        words has length in range [1, 15000].
//        For each test case, up to words.length queries WordFilter.f may be made.
//        words[i] has length in range [1, 10].
//        prefix, suffix have lengths in range [0, 10].
//        words[i] and prefix, suffix queries consist of lowercase letters only.
class WordFilter {
    public static void main(String[] args) {
        WordFilter obj = new WordFilter(new String[]{"apple"});
        int param_1 = obj.f("a", "e");
        System.out.println("0:" + param_1);
        param_1 = obj.f("b", "");
        System.out.println("-1:" + param_1);
    }

    private String[] words;

    public WordFilter(String[] words) {
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

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
