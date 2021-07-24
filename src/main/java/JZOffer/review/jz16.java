package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-17:57
 */

public class jz16 {
    public double myPow(double x, int n) {
        int temp = n;
        long N = n;
        if(N<0){
            N = -N;
        }
        double res = 1.0;
        for(; N>0; N/=2){
            if((N&1)==1){
                res = res*x;
            }
            x = x * x;
        }
        return temp>=0? res : 1.0/(res*1.0);
    }
}
