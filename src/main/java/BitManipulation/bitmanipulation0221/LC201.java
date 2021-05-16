package BitManipulation.bitmanipulation0221;
/*
 * @Description: 201. 数字范围按位与
给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

示例 1:

输入: [5,7]
输出: 4
示例 2:

输入: [0,1]
输出: 0
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/22 0:31
 */
public class LC201 {

    //找到mn的公共前缀,后面的部分一定都为0
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        //将m n一直右移直到两数相等得到公共前缀
        while(m!=n){
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        //再将得到的公共前缀左移之前右移的次数,即后续低位补0
        return m << shift;
    }

    //方法二：Brian Kernighan 算法
    //还有一个位移相关的算法叫做「Brian Kernighan 算法」，它用于清除二进制串中最右边的 11。
    //Brian Kernighan 算法的关键在于我们每次对number和number−1之间进行按位与运算后，
    // number中最右边的1会被抹去变成 0。

//    public int rangeBitwiseAnd(int m, int n){
//        while(m<n){
//            //抹去最右边的1
//            n &= n-1;
//        }
//        return n;
//    }

}
