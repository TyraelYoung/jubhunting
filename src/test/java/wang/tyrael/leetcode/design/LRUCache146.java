package wang.tyrael.leetcode.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import wang.tyrael.leetcode.design.lrucache.LRUCache;
import wang.tyrael.ArrayUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class LRUCache146 {
    @Test
    public void test(){
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        assert cache.get(1) == 1;       // returns 1
        cache.put(3, 3);    // evicts key 2
        assert -1 == cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        assert -1 == cache.get(1);       // returns -1 (not found)
        assert 3 == cache.get(3);       // returns 3
        assert 4 == cache.get(4);       // returns 4



    }

    @Test
    public void test1(){
        System.out.println(new File("src/test/java/wang/tyrael/leetcode/design/testinput1.txt").getAbsolutePath());
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/test/java/wang/tyrael/leetcode/design/testinput1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String lineOperate = scanner.nextLine();
        String lineData = scanner.nextLine();
        String lineResult = scanner.nextLine();
        scanner.close();
        List<String> operates = JSON.parseArray(lineOperate, String.class);
        List<List<Integer>> args = ArrayUtil.parse2DInteger(lineData);
        List<String> result = JSON.parseArray(lineResult, String.class);

        LRUCache cache = new LRUCache( args.get(0).get(0));
        for (int i = 1; i < operates.size(); i++) {
            String operate = operates.get(i);
            List<Integer> arg = args.get(i);
            switch (operate){
                case "put":
                    cache.put(arg.get(0), arg.get(1));
                    break;
                case "get":
                    int expect = Integer.parseInt(result.get(i));
                    int real = cache.get(arg.get(0));
                    if (expect != real){
                        System.out.println("expect:" + expect);
                        System.out.println("real:" + real);
                        System.out.println("i:" + i);
                    }
                    assert expect == real;
                    break;
            }
        }
    }

//    ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
//    [[10],
// [10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],
// [8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],
// [4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],
// [2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],
// [12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],
// [8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
//    [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]

}
