package GreedyAlgorithm.greedy0515;

import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/15-12:31
 */

public class LC1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 0;
        for(int i=0; i<coins.length; i++){
            //当前连续区间为[0,res]
            //如果coins[i]<=res+1
            //从[0,res]任取一个数和coins[i]组合可以得到
            //[0,res]+coins[i] = [coins[i], res+coins[i]], 区间右端点变成了 res+coins[i]
            //此时左端为coins[i]<=res+1 可以和之前的区间[0,res]合并 没有缺口
            //如果coins[i]>=res+2, 此时左端点变成最小值为res+2, 和之前右端点res, 有了一个res+1的缺口,无法连续
            if(coins[i]<=res+1){
                res += coins[i];
            }else{
                break;
            }
        }
        return res+1;
    }
}
