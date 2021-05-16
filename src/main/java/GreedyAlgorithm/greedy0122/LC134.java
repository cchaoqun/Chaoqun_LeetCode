package GreedyAlgorithm.greedy0122;
/*
 * @Description: 134. 加油站
 *
在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。
你从其中的一个加油站出发，开始时油箱为空。
如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
*
说明:
如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
*
示例1:
输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
输出: 3
解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。
*
示例 2:
输入:
gas  = [2,3,4]
cost = [3,4,3]
输出: -1
解释:
你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/gas-station
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/22 10:29
 */
public class LC134 {
    public static void main(String[] args) {
        //[5,1,2,3,4]
        //[4,4,1,5,1]
        //[5,8,2,8]
        //[6,5,6,6]
        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};
        int res = canCompleteCircuit(gas,cost);
        System.out.println(res);
    }

    // gready
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if(len == 0 || cost.length == 0 || len != cost.length){
            return -1;
        }

        //起始加油站下标
        int start = -1;
        int i = 0;
        while(i<len){
            //假设当前为起始点
            start = i;
            int sumgas = 0;
            int sumcost = 0;
            int count = 0;
            while(count < len){
                //环形
                int j = (i + count) % len;
                //总油量和总耗费
                sumgas += gas[j];
                sumcost += cost[j];
                //耗费>油量 则不能到达
                if(sumgas < sumcost){
                    break;
                }
                //可以开到下一个
                count += 1;
            }
            if(count == len){
                //完成了一次循环
                return start;
            }else{
                //退出循环未返回,不能形成环路,重置start,presentGas
                start  = -1;
                //记录当前不能到达的位置,下一次从这个位置出发
                i = i + count + 1;
            }

        }
        return start;
    }
}
