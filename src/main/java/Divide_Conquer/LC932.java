package Divide_Conquer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/21-11:33
 */

public class LC932 {

    @Test
    public void test(){
        int[] res = beautifulArray(4);
        System.out.println(Arrays.toString(res));
    }
    /**
     * 2*A[k] = A[i] + A[j]
     * A[i]存放奇数, A[j]存放偶数 这样右边为奇数, 左边为奇数
     * 对于从1到N的所有整数，奇数个数为 (N + 1) / 2，偶数个数为 N / 2
     *  对于从1到(N + 1)/2的所有整数x，得出其漂亮数组，并映射成1到N范围的所有奇数 2 * x - 1
     *  对于从1到N/2的所有整数x，得出其漂亮数组，并映射成1到N范围的所有偶数 2 * x
     * 而从1到(N + 1)/2以及从1到N/2范围的漂亮数组，则是进一步递归得到的。显然这里会出现重复需要计算的漂亮数组，比如N = 10时，奇偶都需要计算从1到5范围的漂亮数组，因此可以启用哈希表记忆，哈希表的key记录漂亮数组大小N，value记录漂亮数组
     */

    Map<Integer, int[]> memo;
    public int[] beautifulArray(int N){
        this.memo = new HashMap<> ();
        return dfs(N);
    }

    public int[] dfs(int N){
        if(memo.containsKey(N)){
            return memo.get(N);
        }
        //1-N的排列放在数组res中
        int[] res = new int[N];
        if(N==1){
            //长度为1 只能放1
            res[0] = 1;
        }else{
            //将1-N中的奇数放在左边
            int index = 0;
            for(int odd:dfs((N+1)/2)){
                res[index++] = odd*2-1;
            }
            //1-N中的偶数放在右边
            for(int even:dfs(N/2)){
                res[index++] = even*2;
            }
        }
        //当前长度对应的数组放入缓存map
        memo.put(N, res);
        return res;
    }
}
