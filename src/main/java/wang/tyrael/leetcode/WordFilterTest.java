package wang.tyrael.leetcode;

public class WordFilterTest {
    public static void main(String[] args) {
        WordFilter obj;
        WordFilterBrute brute = new WordFilterBrute(new String[]{"apple"});
        int param_1;
//                param_1 = obj.f("a", "e");
//        System.out.println("0:" + param_1);
//
//        param_1 = obj.f("b", "");
//        System.out.println("-1:" + param_1);

//        [[["pop"]],["",""],["","p"],["","op"],["","pop"],["p",""],["p","p"],["p","op"],["p","pop"],["po",""],["po","p"],["po","op"],["po","pop"],["pop",""],["pop","p"],["pop","op"],["pop","pop"],["",""],["","p"],["","gp"],["","pgp"],["p",""],["p","p"],["p","gp"],["p","pgp"],["pg",""],["pg","p"],["pg","gp"],["pg","pgp"],["pgp",""],["pgp","p"],["pgp","gp"],["pgp","pgp"]]
        obj = new WordFilter(new String[]{"pop"});
//        param_1 = obj.f("", "");
//        System.out.println("0:" + param_1);

        param_1 = obj.f("", "op");
        System.out.println("0:" + param_1);

//        param_1 = obj.f("", "p");
//        System.out.println("0:" + param_1);

        //[[["hwxekxrbst","xtmkmgencg","odsdjhjjkk","wxaxuswqxc","rmurhkmuze","kgphhwokcm","lvoapqeppp","pcpsdhfcsh","alztysttkq","nhfttbpzwf"]],
        // ["alztysttkq","tkq"],["al","ysttkq"],["rmurhkmuze","rmurhkmuze"],["kg","kgphhwokcm"],["nhfttbpzwf","fttbpzwf"],["nhfttbpzwf","fttbpzwf"],["xtmkmgencg","mkmgencg"],["kgph","hhwokcm"],["","tysttkq"],["alztystt",""]]
    }
}
