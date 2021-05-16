package GreedyAlgorithm.greedy0514;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-21:14
 */

public class LC991 {
    public int brokenCalc(int x, int y) {
        //x-1操作<=>y+1
        //x*2操作<=>y>>2
        //只能通过x-1一步一步得到y
        if(x>=y){
            return x-y;
        }
        int count = 0;
        while(x<y){
            //y为偶数
            if((y&1)==0){
                //y变成1/2
                count+=1;
                y>>=1;
            }else{
                //y为奇数, 先要+1变成偶数再/2
                //所以需要两步
                count+=2;
                y = (y+1)>>1;
            }
        }
        //x-y的部分需要执行(x-y)次x-1操作得到
        count+=x-y;
        return count;


    }
}
