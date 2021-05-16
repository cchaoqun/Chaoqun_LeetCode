package DynamicProgram.dp0319;
/*
 * @Description: 1025. 除数博弈
爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。



示例 1：

输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
示例 2：

输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。


提示：

1 <= N <= 1000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/19 17:30
 */
public class LC1025 {

    public boolean divisorGame(int N) {
        //dp[i] 表示N=i先手的玩家如果必胜=true 必输=false
        boolean[] dp = new boolean[N+5];
        //(0,1)间没有数字,必输
        dp[1] = false;
        //(0,2)起手只能选1,剩下dp[1]=false所以必胜
        dp[2] = true;
        for(int i=3; i<=N; ++i){
            for(int j=1; j<i; ++j){
                //可以选j因为 i%j==0
                //并且选了j以后剩下的i-j 下一个人dp[i-j]=false必输
                //这样dp[i]可以必胜
                if(i%j==0 && !dp[i-j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
