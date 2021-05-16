package BitManipulation.bitmanipulation0221;
/*
 * @Description: 137. 只出现一次的数字 II
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3
示例 2:

输入: [0,1,0,1,0,1,99]
输出: 99
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/21 20:06
 */
public class LC137_NNNNNN {

    public int singleNumber(int[] nums) {
        int once = 0, twice = 0;
        for(int num:nums){
            once = ~twice & (once ^ num);
            twice = ~once & (twice ^ num);
        }
        return once;
    }
}
