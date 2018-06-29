package wang.tyrael.leetcode.string.compareversion165;

/**
 * @Auther: wangchao
 * @Date: 2018/6/29 17:20
 * @Description:
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.isEmpty()) return 0;
        if (version2 == null || version2.isEmpty()) return 0;
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int minLength = Math.min(split1.length, split2.length);
        for (int i = 0; i < minLength; i++) {
            int v1;
            int v2;
            try {
                v1 = Integer.parseInt(split1[i]);
                v2 = Integer.parseInt(split2[i]);
            } catch (NumberFormatException e) {
                return 0;
            }
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        if (split1.length > split2.length) {
            for (int i = minLength; i < split1.length; i++) {
                int v1 = Integer.parseInt(split1[i]);
                if (v1 > 0){
                    return 1;
                }
            }
        }
        if (split1.length < split2.length) {
            for (int i = minLength; i < split2.length; i++) {
                int v1 = Integer.parseInt(split2[i]);
                if (v1 > 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
