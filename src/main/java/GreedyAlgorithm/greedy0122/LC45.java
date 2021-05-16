package GreedyAlgorithm.greedy0122;
/*
 * @Description: 45. 跳跃游戏 II
 *
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
   从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
说明:
假设你总是可以到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/22 16:00
 */
public class LC45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,2,3};
        int res = jump(nums);
        System.out.println(res);
    }

    //dp[len][2]
    //dp[i][0] = 可以跳到i位置最左边的位置下标
    //dp[i][1] = 跳到i位置的最少步数
    //状态转移方程                                     可以到达
    //dp[j][0] = i if(i+nums[i] > maxJump && i+nums[i] >= j && i < dp[j][0])
    //dp[j][1] = dp[i][1] + 1
//    public static int jump(int[] nums) {
//        int len = nums.length;
//        if(len == 0 || len == 1){
//            return 0;
//        }
//        //dp数组
//        int[][] dp = new int[len][2];
//        //初始化数组 dp[0][0] = 0;
//        for(int i=1; i<len-1; i++){
//            //该列存储的是达到行数对应下标位置的最左下标,
//            dp[i][0] = Integer.MAX_VALUE;
//        }
//        //当前能到达的最远距离
//        int maxJump = 0;
//        for(int i=0; i<len-1; ++i){
//            //判断当前位置能否到达
//            if(maxJump < i){
//                //当前位置不能到达则后续位置也不能到达
//                return -1;
//            }
//            //当前位置能跳到的最远位置
//            int curJump = i + nums[i];
//            if(curJump > maxJump){
//                //能向当前最远位置后续跳的位置个数
//                int j = 1;
//                while(j<=curJump-maxJump && maxJump+j<len){
//                    //当前最远位置后续能跳到的位置都是从i跳过去的
//                    dp[maxJump+j][0] = i;
//                    //需要的步数是从跳到i的基础上再跳一步
//                    dp[maxJump+j][1] = dp[i][1] + 1;
//                    j += 1;
//                }
//                //更新maxJump
//                maxJump = curJump;
//            }
//        }
//        return dp[len-1][1];
//    }

    public static int jump(int[] nums){
        int len = nums.length;
        int end = 0;
        int maxpos = 0;
        int step = 0;
        for(int i=0; i<len-1; i++){
            maxpos = Math.max(maxpos, nums[i]+i);
            if(i==end){
                end = maxpos;
                step += 1;
            }
        }
        return step;
    }

    //反向查找 超时
//    public static int jump(int[] nums){
//        int pos = nums.length -1;
//        int step = 0;
//        while(pos>0){
//            for(int i=0; i<nums.length-1; i++){
//                if(nums[i] + i >= pos){
//                    pos = i;
//                    step += 1;
//                    break;
//                }
//            }
//        }
//        return step;
//    }

}
