package LeetCodeWeeklyContest;

/**
 * @author Chaoqun Cheng
 * @date 2021-08-2021/8/1-10:29
 */

public class Contest_0801_252 {
    public boolean isThree(int n) {
        /**
         一个数一定有1 n这两个除数
         需要求得一定是一个平方数
         并且这个数开平方后的数一定是质数
         */
        int root = isPower(n);
        if(root!=-1 && isPrim(root)){
            return true;
        }
        return false;

    }

    private boolean isPrim(int n){
        for(int i=2; i<=n/2; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    private int isPower(int n){
        for(int i=2; i<=n/2; i++){
            if(i*i==n){
                return i;
            }
            if(i*i>n){
                return -1;
            }
        }
        return -1;
    }

    /**
     * 横坐标
     * 1,n * 2 * (2n+1) = n(n+1)*(2n+1)
     * 纵坐标
     * 2*n(n+1)*(2n+1)
     * n*2*4
     *       n*(n-0+1)
     * 000 00  00 0 0   0 0 0 2^n -1
     *
     *
     *
     */
    public long minimumPerimeter(long neededApples) {
        long n = 1l;
        long num = 12l;
        while(num<neededApples){
            n++;
            num = 2*n*(n+1)*(2*n+1);
        }
        return 8*n;
    }

    public long numberOfWeeks(int[] milestones) {
        /**
         最大的小于总和的一半就可以做完
         否则 = (sum-max)*2+1
         */
        long sum = 0;
        long max = 0;

        for(int x : milestones){
            sum += x;
            max = Math.max(max, x);
        }
        if(max>sum-max){
            //让 max 和 sum-max 消除
            // 最后max还可以再做一次
            return ((sum-max)*2+1);
        }
        //如果最大堆比其他加起来都小，那就只需要看最大堆需要几次才能操作完，
        // 因为当最大堆消耗到一定程度的时候，就是和其他堆的最大值相等时就可以让其他堆进行内部消耗，
        // 直到最大堆再次是最大，这样就可以一直消耗下去

        return sum;
    }
}
