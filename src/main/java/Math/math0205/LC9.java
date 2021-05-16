package Math.math0205;
/*
 * @Description: 9. 回文数
给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

 

示例 1：

输入：x = 121
输出：true
示例 2：

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3：

输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
示例 4：

输入：x = -101
输出：false
 

提示：

-231 <= x <= 231 - 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 17:15
 */
public class LC9 {
    public static void main(String[] args) {
        boolean res = isPalindrome(12321);
        System.out.println(res);
    }

//    public static boolean isPalindrome(int x) {
//        String num = x+"";
//        int p1 = 0, p2 = num.length()-1;
//        while(p1<p2){
//            if(num.charAt(p1)!=num.charAt(p2)){
//                return false;
//            }
//            ++p1;
//            --p2;
//        }
//        return true;
//    }

    //反转数字
    public static boolean isPalindrome(int x){
        //x<0 或者以0结尾但是x!=0的情况一定不为回文数
        if(x<0 || x%10==0 && x!=0){
            return false;
        }
        int rev = 0;
        //翻转右半部分数字
        while(x>rev){
            rev = rev*10 + x%10;
            x /= 10;
        }
        //比较左半边与右半边是否相等
        //x长度为奇数,则将反转后的数字/10去除中间数
        return x==rev || x==rev/10;
    }
}
