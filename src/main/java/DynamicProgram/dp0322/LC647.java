package DynamicProgram.dp0322;
/*
 * @Description: 647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。



示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"


提示：

输入的字符串长度不会超过 1000 。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/23 20:45
 */
public class LC647 {
    public int countSubstrings(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        //dp[i][j] = arr[i:j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        //初始化对角线,一个字符一定是回文串
        for(int i=0; i<len; ++i){
            dp[i][i] = true;
        }
        //每个字符都是一个回文串
        int sum = len;
        for(int i=len-2; i>=0; --i){
            for(int j=i+1; j<len; ++j){
                //判断arr[i:j]是否是字符串,首先头尾一定相等
                if(arr[i]==arr[j]){
                    //如果字符串长度为2 || 去掉头尾中间部分也是回文串,则arr[i:j]是回文串
                    if(j==i+1 || dp[i+1][j-1]){
                        //回文串个数+1
                        ++sum;
                        //当前范围是回文串
                        dp[i][j] = true;
                    }
                }
            }
        }
        return sum;

    }
}
