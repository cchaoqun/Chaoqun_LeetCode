package DynamicProgram.dp0327;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description:
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/27 17:49
 */
public class LC740 {

    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }
        int max = 0;
        //key=nums[i] value=nums[i]出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            //统计每个nums[i]出现的次数
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            //求出最大值
            max = Math.max(max, nums[i]);
        }
        //dp[i] = i这个数为最大值时的最大点数
        int[] dp = new int[max+1];
        //初始化前面两个值的情况
        dp[0] = map.getOrDefault(0,0)*0;
        dp[1] = map.getOrDefault(1,0)*1;
        int res = dp[1];
        for(int i=2; i<max+1; i++){
            //当前i不选,和i-1的情况一样dp[i-1]
            //当前i选,前面一个i-1不能选 当前分数i*(i出现的次数)+dp[i-2]
            dp[i] = Math.max(dp[i-1], dp[i-2]+map.getOrDefault(i,0)*(i));
            //更新最大值
            res = Math.max(res, dp[i]);
        }
        return res;


    }
}
