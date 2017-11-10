package wang.tyrael.bianchengzhimei;

public class Bian2_4 {
    public static void main(String args[]) {
        System.out.println(count1(23));
    }

    public static int count1(int n) {
        int iCount = 0;
        int iFactor = 1;
        int iLowerNum = 0;
        int iCurrNum = 0;
        int iHigherNum = 0;

        while (n / iFactor != 0) {
            iLowerNum = n - (n / iFactor) * iFactor;
            iCurrNum = (n / iFactor) % 10;
            iHigherNum = n / (iFactor * 10);

            System.out.println("iLowerNum:" + iLowerNum);
            System.out.println("iCurrNum:" + iCurrNum);
            System.out.println("iHigherNum:" + iHigherNum);

            switch (iCurrNum) {
                case 0:
                    iCount += iHigherNum * iFactor;
                    break;
                case 1:
                    iCount += iHigherNum * iFactor + iLowerNum + 1;
                    break;
                default:
                    iCount += (iHigherNum + 1) * iFactor;
                    break;
            }
            iFactor *= 10;

            System.out.println("iCount:" + iCount);
        }

        return iCount;
    }
}
