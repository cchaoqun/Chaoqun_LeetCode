package Algorithm_HW.Week4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/1-13:33
 */

public class LC464 {




    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal){
            return true;
        }
        if(maxChoosableInteger*(maxChoosableInteger+1)/2 < desiredTotal){
            return false;
        }
        /**
         1<<maxChoosableInteger 这么长的二进制空间, 每个位置表示state这个状态是否被计算过 计算过直接返回计算过的值
         state 每个bit上代表i是否被选择过 选择过对应位置上是1
         */
        return dfs(new Boolean[1<<maxChoosableInteger], 0, maxChoosableInteger, desiredTotal);

    }

    private boolean dfs(Boolean[] dp, int state ,int range, int target){
        if(dp[state]!=null){
            return dp[state];
        }
        for(int i=1; i<=range; i++){
            //当前i 在二进制中的第i-1位应该是1
            int cur = 1 << (i-1);
            //这个选择与state& 如果不是0 说明state这个位上也是1, 说明这个数字选择过 跳过
            if((state&cur)!=0){
                continue;
            }
            //这个数没选过 可选的数>=target可以赢, 或者选了i对方不能赢
            if(i>=target || !dfs(dp, state|cur, range, target-i)){
                dp[state] = true;
                return true;
            }
        }
        dp[state]=false;
        return false;
    }
}

class LC464_M2{
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int n = maxChoosableInteger;
        if(n >= desiredTotal){
            return true;
        }
        if(n*(n+1)/2 < desiredTotal){
            return false;
        }
        boolean[] used = new boolean[n+1];
        return helper(n, desiredTotal, used, true);
    }
    public boolean helper(int n, int target, boolean[] used, boolean isMe){
//        if(target <= 0 && isMe){
//            return false;
//        }
//        if(target <= 0 && !isMe){
//            return true;
//        }
        boolean result = false;
        for(int i = 1; i <= n; i++){
            if(used[i]){
                continue;
            }
            System.out.println(i + " " + target);
            used[i] = true;
            if(helper(n, target - i, used, !isMe)){
                used[i] = false;
                return true;
            }
            used[i] = false;
        }
        return result;
    }
}
