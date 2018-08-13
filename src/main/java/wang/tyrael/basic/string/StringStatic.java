package wang.tyrael.basic.string;

/**
 * @author: wangchao
 * 2018/8/12 0012
 */
public class StringStatic {
    public boolean isSubsequence(String sub, String parent) {
        if (sub.length() == 0) return true;
        int indexSub = 0, indexParent = 0;
        while (indexParent < parent.length()) {
            if (parent.charAt(indexParent) == sub.charAt(indexSub)) {
                indexSub++;
                if (indexSub == sub.length()) return true;
            }
            indexParent++;
        }
        return false;
    }

}
