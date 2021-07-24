package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-18:18
 */

public class jz17 {
    public int[] printNumbers(int n) {
        //最大的n位数是 10^n-1
        int[] res = new int[myPow(n)-1];
        for(int i=0; i<res.length; i++){
            res[i] = i+1;
        }
        return res;
    }
    //求出10^n
    private int myPow(int n){
        int res = 1;
        int rem = 10;
        while(n>0){
            if((n&1)==1){
                res = res*rem;
            }
            rem = rem * rem;
            n>>=1;
        }
        return res;
    }
}
