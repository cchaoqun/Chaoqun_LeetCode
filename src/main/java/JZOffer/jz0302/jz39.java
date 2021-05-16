package JZOffer.jz0302;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 剑指 Offer 39. 数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。



你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2


限制：

1 <= 数组长度 <= 50000



注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/2 18:21
 */
public class jz39 {

    //摩尔投票法
    //推论一： 若记 众数 的票数为 +1 ，非众数 的票数为 -1 ，则一定有所有数字的 票数和 >0。
    //推论二： 若数组的前 a个数字的 票数和 = 0 ，则 数组剩余 (n-a)个数字的 票数和一定仍 >0 ，即后 (n-a) 个数字的 众数仍为 x 。

    public int majorityElement(int[] nums) {
        //假设第一个元素为众数
        int candidate = nums[0];
        //众数出现次数为1
        int count = 1;
        for(int i=1; i<nums.length; ++i){
            //如果当前数字与candidate相等
            if(nums[i]==candidate){
                //出现次数+1
                ++count;
            }else if(count>0){
                //不等,则出现次数-1
                --count;
            }else{
                //count=0
                //假设当前数字为candidate
                candidate = nums[i];
                //出现次数+1
                count += 1;
            }
        }
        //如果不确定一定会有众数的情况下,需要遍历数组统计candidate出现的次数,如果<nums.length/2,则不存在众数
        return candidate;
    }

//    public int majorityElement(int[] nums){
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0; i<nums.length; ++i){
//            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//        }
//        int candidate = -1;
//        int count = -1;
//        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//            if(count==-1 || entry.getValue() > count){
//                candidate = entry.getKey();
//                count = entry.getValue();
//            }
//        }
//        return candidate;
//    }
}
