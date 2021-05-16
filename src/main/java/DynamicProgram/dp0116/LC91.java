package DynamicProgram.dp0116;
/*
 * @Description: 91. 解码方法
一条包含字母A-Z 的消息通过以下映射进行了 编码 ：

'A' -> 1
'B' -> 2
...
'Z' -> 26
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，
或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
题目数据保证答案肯定是一个 32 位 的整数。
*
示例 1：
输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
*
示例 2：
输入：s = "226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
*
示例 3：
输入：s = "0"
输出：0
解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
*
示例 4：
输入：s = "1"
输出：1

提示：
1 <= s.length <= 100
s 只包含数字，并且可能包含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/21 17:07
 */
public class LC91 {
    public static void main(String[] args) {
        String s = "112316";
        int res = numDecodings(s);
        System.out.println(res);

    }


    // dp
    // dp[i] = 以S[i]结尾的前缀子串有多少中解码方式
    // s[i] != 0 dp[i] = dp[i-1] 因为s[i]可以单独作为一种解码方式添加到所有s[i-1]结尾的前缀子串解码方式中
    // if 10 <= s[i-1,j] <= 26, dp[i] += dp[i-2]
    //  如果s[i-1,i]字符串对应的数字在[10,26]的闭区间.
    //  说明s[i-1,i]可以作为一个单独的解码方式添加到以s[i-2]结尾的前缀子串解码方式中
    public static int numDecodings(String s) {
        int len = s.length();
        if (len == 0){
            return 0;
        }
        //将s转换成字符数组,如果用s.charAt(),每次都会判断下标是否越界,降低性能
        char[] str = s.toCharArray();
        //如果字符串以'0'起始,则没有解码方式
        if(str[0] == '0'){
            return 0;
        }
        //dp数组
        int[] dp = new int[len];
        //初始化第一个位置
        dp[0] = 1;

        for(int i=1; i<len; ++i){
            //判断当前字符=='0'
            if(str[i] != '0'){
                //dp[i] = dp[i-1] 因为s[i]可以单独作为一种解码方式添加到所有s[i-1]结尾的前缀子串解码方式中
                dp[i] = dp[i-1];
            }
            //判断s[i-1,i]能否组成一种解码方式
            //将当前字符与前一个字符的组成的两位数转换成int类型
            int temp = 10*(int)(str[i-1]-'0') + (int)(str[i]-'0');
            //判断该两位数是否在[10,26]之间
            if(10<=temp && temp<=26) {
                //判断i==1的情况
                if (i == 1) {
                    dp[i]++;
                } else {
                    //s[i-1,i]可以作为一个单独的解码方式添加到以s[i-2]结尾的前缀子串解码方式中
                    //在之前的基础上,又多了dp[i-2]中方法
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len-1];
    }
}
