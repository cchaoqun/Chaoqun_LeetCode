package Algorithm_HW.Week8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/24-14:34
 */

public class LC322 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //dp[i] amount=i所需的最小的coins数量
        // dp[i] = Math.min(dp[i-coin[k]]+1) 选择coins[k] 剩下的为i-coin[k] 并且i-coin[k]可以组合成功
        int[] dp = new int[amount+1];
        //初始化默认都不能组成
        Arrays.fill(dp, Integer.MAX_VALUE);
        //0可以 都不选就是0
        dp[0] = 0;
        //遍历每个target
        for(int i=0; i<=amount; i++){
            //遍历可以放的硬币数量
            for(int c : coins){
                //只要当前硬币面值小于目标 并且目标减去硬币的面值剩下的也可以被某种组合组成
                if(i-c>=0 && dp[i-c]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-c]+1, dp[i]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    @Test
    public void test(){
        int[] coins = new int[]{411,412,413,414,415,416,417,418,419,420,421,422};
        System.out.println(coinChange(coins, 9864));
    }
}

class LC322_M3{
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] count = new int[amount+1];
        return dfs(coins, amount, count);

    }

    // 组成target的硬币组合总数 = count[target]
    private int dfs(int[] coins, int target, int[] count){
        if(target<0){
            return -1;
        }
        if(target==0){
            return 0;
        }
        if(count[target]!=0){
            return count[target];
        }
        int cnt = Integer.MAX_VALUE;
        for(int i : coins){
            int curMin = dfs(coins, target-i, count);
            if(curMin>=0){
                cnt = Math.min(curMin+1, cnt);
            }
        }
        count[target] = cnt==Integer.MAX_VALUE?-1:cnt;
        return count[target];
    }

}


class LC322_M2{
    //backtracking 找出所有的解 但是超时
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int index = coins.length-1;
        int size = 0;
        int[] min = new int[]{Integer.MAX_VALUE};
        backtrack(coins, amount,min, index, size);
        return min[0]==Integer.MAX_VALUE?-1:min[0];
    }

    private void backtrack(int[] coins, int target,int[] min , int index, int size){
        if(size>=min[0]){
            return;
        }

        if(index==-1){
            if(target==0){
                min[0] = Math.min(min[0], size);
            }
            return ;
        }
        // 加coins[index]
        if(target-coins[index]>=0){
            backtrack(coins, target-coins[index], min, index, size+1);
        }
        // 不加coins[index]
        backtrack(coins, target, min, index-1, size);
    }
}