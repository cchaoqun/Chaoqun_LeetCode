package GreedyAlgorithm.greedy0510;

/**
 * 1774. 最接近目标价格的甜点成本
 * 你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
 *
 * 必须选择 一种 冰激凌基料。
 * 可以添加 一种或多种 配料，也可以不添加任何配料。
 * 每种类型的配料 最多两份 。
 * 给你以下三个输入：
 *
 * baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
 * toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
 * target ，一个整数，表示你制作甜点的目标价格。
 * 你希望自己做的甜点总成本尽可能接近目标价格 target 。
 *
 * 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
 *
 *
 *
 * 示例 1：
 *
 * 输入：baseCosts = [1,7], toppingCosts = [3,4], target = 10
 * 输出：10
 * 解释：考虑下面的方案组合（所有下标均从 0 开始）：
 * - 选择 1 号基料：成本 7
 * - 选择 1 份 0 号配料：成本 1 x 3 = 3
 * - 选择 0 份 1 号配料：成本 0 x 4 = 0
 * 总成本：7 + 3 + 0 = 10 。
 * 示例 2：
 *
 * 输入：baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
 * 输出：17
 * 解释：考虑下面的方案组合（所有下标均从 0 开始）：
 * - 选择 1 号基料：成本 3
 * - 选择 1 份 0 号配料：成本 1 x 4 = 4
 * - 选择 2 份 1 号配料：成本 2 x 5 = 10
 * - 选择 0 份 2 号配料：成本 0 x 100 = 0
 * 总成本：3 + 4 + 10 + 0 = 17 。不存在总成本为 18 的甜点制作方案。
 * 示例 3：
 *
 * 输入：baseCosts = [3,10], toppingCosts = [2,5], target = 9
 * 输出：8
 * 解释：可以制作总成本为 8 和 10 的甜点。返回 8 ，因为这是成本更低的方案。
 * 示例 4：
 *
 * 输入：baseCosts = [10], toppingCosts = [1], target = 1
 * 输出：10
 * 解释：注意，你可以选择不添加任何配料，但你必须选择一种基料。
 *
 *
 * 提示：
 *
 * n == baseCosts.length
 * m == toppingCosts.length
 * 1 <= n, m <= 10
 * 1 <= baseCosts[i], toppingCosts[i] <= 104
 * 1 <= target <= 104
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-19:31
 */

public class LC1774 {
    int res = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target){
        //遍历每种选择的冰淇淋的底料
        for(int cost:baseCosts){
            //递归匹配每种可能的配料搭配
            dfs(0, cost, toppingCosts,target);
        }
        return res;
    }
    public void dfs(int cur, int cost, int[] toppingCosts, int target){
        //当前底料花费与之前的结果的比较
        int diff = Math.abs(target-cost)-Math.abs(target-res);
        if(diff<0 || diff==0 && cost<res){
            res = cost;
        }
        //当前冰淇淋底料已经大于target 剪枝
        if(cost>=target){
            return;
        }
        //当前topping选择1||2, 并且在这个基础上向下一个topping递归
        for(int i=cur; i<toppingCosts.length; i++){
            dfs(i+1, cost+toppingCosts[i], toppingCosts, target);
            dfs(i+1, cost+2*toppingCosts[i], toppingCosts, target);
        }
    }
}

class LC1774_M2{
    int res = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target){
        for(int cost:baseCosts){
            dfs(0, cost, toppingCosts,target);
        }
        return res;
    }

    public void dfs(int cur, int cost, int[] toppingCosts, int target){
        int diff = Math.abs(target-cost)-Math.abs(target-res);
        if(diff<0 || diff==0 && cost<res){
            res = cost;
        }
        //这里没有for循环控制cur是否超出toppingCosts下标界.需要额外判断
        if(cost>=target || cur==toppingCosts.length){
            return;
        }
        //当前topping 选择+0||1||2
        dfs(cur+1, cost, toppingCosts, target);
        dfs(cur+1, cost+toppingCosts[cur], toppingCosts, target);
        dfs(cur+1, cost+2*toppingCosts[cur], toppingCosts, target);

    }
}

































