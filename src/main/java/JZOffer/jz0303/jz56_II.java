package JZOffer.jz0303;
/*
 * @Description: 剑指 Offer 56 - II. 数组中数字出现的次数 II
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。



示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1


限制：

1 <= nums.length <= 10000
1 <= nums[i] < 2^31
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 21:10
 */
public class jz56_II {
    public int singleNumber(int[] nums){
        //三种状态,需要两位数表示, two one two代表第1位, one代表第0位
        //finite state machine 三种状态
//        if(two==0){
//            if(n==0){
//                one = one;
//            }else{
//                one = ~n;
//            }
//        }
//        if(two==1){
//            one = 0
//        }
        //每次先计算one
        //再根据新的one计算two
        int one = 0, two = 0;
        for(int n:nums){
            one = one^n & ~two;
            two = two^n & ~one;
        }
        return one;
    }

    //统计各位置上的数位和
//    public int singleNumber(int[] nums){
//        int[] bitArr = new int[32];
//        //统计每个位置上各个数字的和
//        for(int i=0; i<nums.length; ++i){
//            int cur = nums[i];
//            for(int j=0; j<32; ++j){
//                bitArr[j] += cur & 1;
//                cur >>>= 1;
//
//            }
//        }
//        //每个位置上的数字%m
//
//        int res = 0, m =3;
//        for(int i=0; i<32; ++i){
//            res <<= 1;
//            res |= bitArr[31-i]%3;
//        }
//        return res;
//    }
}
