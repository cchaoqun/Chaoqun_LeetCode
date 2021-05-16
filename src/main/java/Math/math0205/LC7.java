package Math.math0205;
/*
 * @Description: 7. 整数反转
给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。
 

示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0
 

提示：

-231 <= x <= 231 - 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 16:36
 */
public class LC7 {
    public static void main(String[] args) {
        int res = reverse(-2147483412);
        System.out.println(res);
    }

    //
    public static int reverse(int x) {
        int res  = 0;
        while(x!=0){
            //超出整数范围的情况 [-2147483648,2147483647]-2147483412
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10  && (x%10)>7)){
                return 0;
            }
            if(res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && (x%10)<-8)){
                return 0;
            }
            res = res * 10 + x%10;
            x = x/10;

        }
        return res;
    }
}
