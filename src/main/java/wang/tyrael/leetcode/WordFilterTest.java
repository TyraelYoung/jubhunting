package wang.tyrael.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class WordFilterTest {
    public static void main(String[] args) {
        WordFilter obj;
        WordFilterBrute brute = new WordFilterBrute(new String[]{"apple"});
        int param_1;
        obj = new WordFilter(new String[]{"apple"});
                param_1 = obj.f("a", "e");
        System.out.println("0:" + param_1);

        param_1 = obj.f("b", "");
        System.out.println("-1:" + param_1);

//        [[["pop"]],["",""],["","p"],["","op"],["","pop"],["p",""],["p","p"],["p","op"],["p","pop"],["po",""],["po","p"],["po","op"],["po","pop"],["pop",""],["pop","p"],["pop","op"],["pop","pop"],["",""],["","p"],["","gp"],["","pgp"],["p",""],["p","p"],["p","gp"],["p","pgp"],["pg",""],["pg","p"],["pg","gp"],["pg","pgp"],["pgp",""],["pgp","p"],["pgp","gp"],["pgp","pgp"]]
        obj = new WordFilter(new String[]{"pop"});
        param_1 = obj.f("", "");
        System.out.println("0:" + param_1);

        param_1 = obj.f("", "op");
        System.out.println("0:" + param_1);

        param_1 = obj.f("", "p");
        System.out.println("0:" + param_1);

        List<String> p = JSON.parseArray("[[[\"hwxekxrbst\",\"xtmkmgencg\",\"odsdjhjjkk\",\"wxaxuswqxc\",\"rmurhkmuze\",\"kgphhwokcm\",\"lvoapqeppp\",\"pcpsdhfcsh\",\"alztysttkq\",\"nhfttbpzwf\"]],[\"alztysttkq\",\"tkq\"],[\"al\",\"ysttkq\"],[\"rmurhkmuze\",\"rmurhkmuze\"],[\"kg\",\"kgphhwokcm\"],[\"nhfttbpzwf\",\"fttbpzwf\"],[\"nhfttbpzwf\",\"fttbpzwf\"],[\"xtmkmgencg\",\"mkmgencg\"],[\"kgph\",\"hhwokcm\"],[\"\",\"tysttkq\"],[\"alztystt\",\"\"]]",
                String.class);

        List<String> src = JSON.parseArray(p.get(0), String.class);
        List<String> words = JSON.parseArray(src.get(0), String.class);

        String[] wArray = words.toArray(new String[words.size()]);
        WordFilter toTest = new WordFilter(wArray);
        brute = new WordFilterBrute(wArray);

        for (int i = 1; i < p.size(); i++) {
            String item = p.get(i);
            List<String> ps = JSON.parseArray(item, String.class);
            System.out.println("关键词：" + ps.get(0) + "," + ps.get(1) + ":" + brute.f(ps.get(0), ps.get(1)) + ":" + toTest.f(ps.get(0), ps.get(1)));
        }




     }
}
