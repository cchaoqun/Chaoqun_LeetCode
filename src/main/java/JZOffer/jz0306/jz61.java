package JZOffer.jz0306;

import java.util.HashSet;
import java.util.Set;

/*
 * @Description:剑指 Offer 61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。



示例 1:

输入: [1,2,3,4,5]
输出: True


示例 2:

输入: [0,0,1,2,5]
输出: True


限制：

数组长度为 5

数组的数取值为 [0, 13] .
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/6 19:00
 */
public class jz61 {

    public boolean isStraight(int[] nums) {
        int pre = 0;
        int max = -1;
        int min = 14;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; ++i){
            if(nums[i]==0){
                continue;
            }
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            if(set.contains(nums[i])){
                //重复则不可能各位顺子
                return false;
            }
            set.add(nums[i]);
        }
        return max-min<5;
    }
}
