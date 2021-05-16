package DynamicProgram.dp0326;

import java.util.Arrays;

/*
 * @Description: 1024. 视频拼接
你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。

视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。

我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。



示例 1：

输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
输出：3
解释：
我们选中 [0,2], [8,10], [1,9] 这三个片段。
然后，按下面的方案重制比赛片段：
将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
示例 2：

输入：clips = [[0,1],[1,2]], T = 5
输出：-1
解释：
我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
示例 3：

输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
输出：3
解释：
我们选取片段 [0,4], [4,7] 和 [6,9] 。
示例 4：

输入：clips = [[0,4],[2,8]], T = 5
输出：2
解释：
注意，你可能录制超过比赛结束时间的视频。


提示：

1 <= clips.length <= 100
0 <= clips[i][0] <= clips[i][1] <= 100
0 <= T <= 100
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/26 14:25
 */
public class LC1024 {

    //dp O(TN)
    public int videoStitching(int[][] clips, int T) {
        //dp[i] = [0,i)区间覆盖所需要的最小数量
        int[] dp = new int[T+1];
        //初始化为较大值,矩阵最多含有100个片段,则最多需要100个片段
        Arrays.fill(dp, 101);
        //[0,0)区间为空,需要0
        dp[0] = 0;
        for(int i=1; i<=T; i++){
            //对于[0,i]区间
            for(int[] clip : clips){
                //所求区间右端点在当前clip中间, [clip[0], i]已经被覆盖
                //需要求出[0,clip[0]]所需的数量
                if(clip[0]<i && i<=clip[1]){
                    dp[i] = Math.min(dp[i], dp[clip[0]]+1);
                }
            }
        }
        return dp[T]==101?-1:dp[T];
    }


}

class LC1024_M2{
    //贪心 O(T)
    public int videoStitching(int[][] clips, int T){
        //maxRight[i] = i位置起始能达到的最右边的距离
        int[] maxRight = new int[T];
        for(int[] clip:clips){
            if(clip[0]<T)
                maxRight[clip[0]] = Math.max(maxRight[clip[0]], clip[1]);
        }
        int pre = 0;
        int last = 0;
        int res = 0;
        for(int i=0; i<T; i++){
            //更新当前i位置能到达的最远的距离
            last = Math.max(last, maxRight[i]);
            //如果i位置最远能达到只能是last,则不能达到T
            if(i==last){
                return -1;
            }
            //用完了上一个区间,更新为当前所在区间的右端点 即  last
            if(i==pre){
                res++;
                pre = last;
            }
        }
        return res;
    }


}