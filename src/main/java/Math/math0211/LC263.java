package Math.math0211;
/*
 * @Description: 263. 丑数
编写一个程序判断给定的数是否为丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例 1:

输入: 6
输出: true
解释: 6 = 2 × 3
示例 2:

输入: 8
输出: true
解释: 8 = 2 × 2 × 2
示例 3:

输入: 14
输出: false
解释: 14 不是丑数，因为它包含了另外一个质因数 7。
说明：

1 是丑数。
输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/11 13:43
 */
public class LC263 {

    public boolean isUgly(int num) {
        //1 是丑数
        if(num==1){
            return true;
        }
        //丑数是正整数
        if(num<=0){
            return false;
        }
        //先将其中包含的5除掉
        while(num % 5 == 0){
            num /= 5;
        }
        //再将包含的3除掉
        while(num % 3 == 0){
            num /= 3;
        }
        //最后将2除掉
        while(num % 2 == 0){
            num /= 2;
        }
        //如果是丑数,则只包含2,3,5, 因此此时num==1则为丑数
        return num == 1;

    }
}
