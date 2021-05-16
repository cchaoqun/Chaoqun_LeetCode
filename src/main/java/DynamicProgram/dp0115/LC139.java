package DynamicProgram.dp0115;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Description: 139. 单词拆分
 *
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
*
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
*
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
    注意你可以重复使用字典中的单词。
    *
示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-break
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 22:48
 */
public class LC139 {

    public boolean wordBreak(String s, List<String> wordDict){
        //利用hashset确认分割的字符串是否存在于字典中
        Set<String> dict = new HashSet<>(wordDict);
        //确认下标对应的长度的字符串是否存在于字典中 dp[i] = 前i-1个字符串是否出现在字典中
        boolean[] dp = new boolean[s.length()+1];
        //空字符串符合
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                //从左到右依次分割,在j点分开为 0~j-1 j~i-1
                if(dp[j]&&dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
