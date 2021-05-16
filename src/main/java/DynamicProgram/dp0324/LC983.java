package DynamicProgram.dp0324;
/*
 * @Description: 983. 最低票价
在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。

火车票有三种不同的销售方式：

一张为期一天的通行证售价为 costs[0] 美元；
一张为期七天的通行证售价为 costs[1] 美元；
一张为期三十天的通行证售价为 costs[2] 美元。
通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。

返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。



示例 1：

输入：days = [1,4,6,7,8,20], costs = [2,7,15]
输出：11
解释：
例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
你总共花了 $11，并完成了你计划的每一天旅行。
示例 2：

输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
输出：17
解释：
例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
你总共花了 $17，并完成了你计划的每一天旅行。


提示：

1 <= days.length <= 365
1 <= days[i] <= 365
days 按顺序严格递增
costs.length == 3
1 <= costs[i] <= 1000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/24 17:15
 */
public class LC983 {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        //第一天天数
        int firstDay = days[0];
        //最后一天天数
        int lastDay = days[len-1];

        //dp[i]=第i天出门所需的最小花费
        int[] dp = new int[lastDay+31];
        int i = len-1;
        //遍历从[firstDay,lastDay]中所有的天数
        for(int day=lastDay; i>=0 && day>=firstDay; --day){
            //当前天数
            int curDay = days[i];
            //如果和days[i]相等,当前天需要出门
            if(day==curDay){
                //三种选择
                //1天票,只能cover当天,下一个需要买票的天数为day+1
                //7天票,cover到day+7-1天, 下一个需要买票的天数为day+7
                //30天票,cover到day+30-1天,下一个需要买票的天数为day+30
                //取三种当中的最小值,为当前day天出发的最小花费
                dp[day] = Math.min(Math.min(dp[day+1]+costs[0], dp[day+7]+costs[1]), dp[day+30]+costs[2]);
                //i为days[]数组的索引,下一个需要出门的天数为days[i--]
                --i;
            }else{
                //当前天不需要出门,花费与明天出门的花费相同
                dp[day] = dp[day+1];
            }
        }
        //返回第一天需要出门的花费
        return dp[firstDay];

    }
}
