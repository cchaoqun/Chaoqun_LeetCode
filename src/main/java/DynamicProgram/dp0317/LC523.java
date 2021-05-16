package DynamicProgram.dp0317;

import java.util.HashMap;

/*
 * @Description: 523. 连续的子数组和
给定一个包含 非负数 的数组和一个目标 整数 k ，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。



示例 1：

输入：[23,2,4,6,7], k = 6
输出：True
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
示例 2：

输入：[23,2,6,4,7], k = 6
输出：True
解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。


说明：

数组的长度不会超过 10,000 。
你可以认为所有数字总和在 32 位有符号整数范围内。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/17 21:43
 */
public class LC523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        //前缀和数组, preSum[i] = sum[nums[0], nums[i-1]]
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i=1; i<=nums.length; ++i){
            preSum[i] = preSum[i-1] + nums[i];
        }

        //连续子数组长度最小为2,left最右到达倒数第二个位置
        for(int left=0; left<nums.length-1; ++left){
            for(int right=left+1; right<nums.length; ++right){
                //     sum[nums[0],nums[right] - sum[nums[0],nums[left-1]] = sum[nums[left],nums[right]]
                //当前区间[left,right]的和
                int sum = preSum[right+1] - preSum[left];
                //k有可能==0, 分k=0 / k!=0 的两种情况讨论
                if(sum==k || (k!=0 && sum%k==0)){
                    return true;
                }
            }
        }
        return false;
    }
}

class LC523_M2{
    public boolean checkSubarraySum(int[] nums, int k){
        int sum = 0;
        //sum%k的余数 rem  对应前缀和的元素下标
        HashMap<Integer, Integer> map = new HashMap<>();
        //解决[0,0]的情况
        map.put(0, -1);
        for(int i=0; i<nums.length; ++i){
            //这里即便后续 % k 不影响,
            //相当于把 n个k都去除掉了,剩下的只有对应i,j余数
            sum += nums[i];
            if(k!=0){
                //取余数
                sum %= k;
            }
            if(map.containsKey(sum)){
                //保证子数组长度>=2
                if(i-map.get(sum)>1){
                    return true;
                }
            }else{
                map.put(sum, i);
            }

        }
        return false;
    }
}
