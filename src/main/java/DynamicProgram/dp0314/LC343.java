package DynamicProgram.dp0314;
/*
 * @Description: 343. 整数拆分
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/14 21:45
 */
public class LC343 {

    public int integerBreak(int n) {
        if(n<=3){
            //n=2 return 1*1 = 1 =2-1
            //n=3 return 1*2 = 2 =3-1
            return n-1;
        }
        //n尽可能等分乘积更大
        //n等分成的因子为3时,乘积更大
        //p=n有多少个3
        int p = n / 3;
        //r=n除以3的余数
        int r = n % 3;
        if(r==1){
            //如果余数为1 需要从p个3中拿出一个3与1凑成 4 = (2*2) > 3*1
            return (int)Math.pow(3,p-1)*4;
        }
        if(r==2){
            //如果余数为2 则直接乘以2即可 没有优化的空间
            return (int)Math.pow(3,p)*2;
        }
        // 如果余数为0 直接返回p个3相乘的结果即可
        return (int)Math.pow(3,p);
    }
}
