package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-17:57
 */

public class jz15 {
    public int hammingWeight(int n) {
        int res = 0;
        // n!=0 n可能<0 最高位为1 但是要将n看成无符号
        while(n!=0){
            res += n&1;
            n >>>= 1;
        }
        return res;
    }
}
