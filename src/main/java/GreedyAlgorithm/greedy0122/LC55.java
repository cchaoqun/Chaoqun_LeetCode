package GreedyAlgorithm.greedy0122;
/*
 * @Description: 55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

示例1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
*
示例2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/22 11:51
 */
public class LC55 {
    public static void main(String[] args) {
        int[] nums = {2,5,0,0,0,0,1};
        boolean res = canJump(nums);
        System.out.println(res);
    }

    //对于当前位置,判断能否到达,即当前最远距离是否>=当前坐标
    //用一个变量保存能跳到的最远距离,当前位置只判断能跳到的最远位置是否大于最远距离,是则替换
    //最后判断能跳到的最远距离是否大于等于最后一个点
    //如果碰到0则continue,因为0的格子没有任何帮助
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        //最远可以到达的位置下标
        int maxJump = 0;
        for(int i=0; i<len-1; i++) {
            //判断当前位置是否能达到
            if(maxJump<i){
                return false;
            }
            if(nums[i] == 0){
                continue;
            }
            //本位置能到达的最远距离
            int curJump = nums[i] + i;
            if(curJump > maxJump){
                maxJump = curJump;
            }
        }
        //最远距离是否>=最后一个位置
        return maxJump >= len-1? true:false;
    }
}
