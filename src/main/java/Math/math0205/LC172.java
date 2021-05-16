package Math.math0205;
/*
 * @Description: 172. 阶乘后的零
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:

输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。
示例 2:

输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
说明: 你算法的时间复杂度应为 O(log n) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 19:27
 */
public class LC172 {
    public static void main(String[] args) {
        int n = 20;
        int res = trailingZeroes(n);
        System.out.println(res);


    }

    //末尾的0只会由10构成
    //10只能由2*5构成
    //2每隔2个数出现
    //5每隔5个数出现一次,2出现的频率远大于5,我们只需要找到n以内出现了多少个5即可
    //  每隔5个数出现1个5,每隔25(5*5)出现2个5,每隔125(5*5*5)出现3个5,以此类推
    //  因此每隔5需要加n/5; 每隔25个数需要多加n/25; 每隔125个数需要多加n/125
    //  最终5的个数就是: n/5+n/25+n/125+...
    public static int trailingZeroes(int n) {
        int count = 0;
        while(n>0){
            count += n/5;
            //防止分母溢出,将n/5,下一次就等于原始的n/25... 以此类推
            n = n/5;
        }
        return count;
    }
}
