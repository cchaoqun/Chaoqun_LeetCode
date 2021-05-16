package JZOffer.jz0303;
/*
 * @Description: 剑指 Offer 56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。



示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]


限制：

2 <= nums.length <= 10000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 20:40
 */
public class jz56 {
    public int[] singleNumbers(int[] nums) {
        int xOR = 0;
        //数组中所有数字按位异或, 0与所有数字按位异或的值都是本身
        for(int n: nums){
            xOR ^= n;
        }
        //找到最后按位异或结果中随便的一个1
        int one = 1;
        while((xOR&one)==0){
            one <<= 1;
        }
        //通过这个为1的数,将数组分成两部分,因为相同的数与1按位与的结果一定一样
        //而唯一出现一次的数字一定在该位置上不同所以最后的结果在该位上才是1
        //将数组所有的数字与这个one按位与,两个出现一次的数字一定被分到两边,
        //将分到一边得数字全部按位异或,最后得到的两个结果就是出现一次的这两个数
        int left = 0, right =0;
        for(int n:nums){
            //拆分nums为两个子数组,分别按位异或得到两个值
            if((n&one)==0){
                left ^= n;
            }else{
                right ^= n;
            }
        }
        return new int[]{left,right};
    }
}
