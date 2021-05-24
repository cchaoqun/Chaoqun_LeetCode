package Divide_Conquer;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/20-16:58
 */

public class Interview1710 {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int n = nums.length;
        int pre = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++){
            int cur = nums[i];
            //和候选人相同
            if(cur==pre){
                count++;
            }else if(count==0){
                //之前全部抵消, 从当前重新开始
                pre = cur;
                count = 1;
            }else if(count>0){
                //之前候选人票数-1
                count -=1;
            }
        }
        //检查是否真的>n/2
        int num = 0;
        for(int i:nums){
            num += i==pre?1:0;
        }
        return num>n/2?pre:-1;
    }

}
