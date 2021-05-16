package JZOffer.jz0303;
/*
 * @Description: 剑指 Offer 49. 丑数
我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。



示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:

1 是丑数。
n 不超过1690。
注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 17:21
 */
public class jz49 {

    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for(int i=1; i<n; ++i){
            //当前数字为对应三个指针指向位置元素乘以 2,3,5中的最小值
            ugly[i] = Math.min(Math.min(ugly[p2]*2, ugly[p3]*3), ugly[p5]*5);
            if(ugly[i] == ugly[p2]*2){
                ++p2;
            }
            if(ugly[i] == ugly[p3]*3){
                ++p3;
            }
            if(ugly[i] == ugly[p5]*5){
                ++p5;
            }
        }
        return ugly[n-1];
    }
}
