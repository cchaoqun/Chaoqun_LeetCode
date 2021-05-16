package GreedyAlgorithm.greedy0427;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/27-17:48
 */

public class LC1217 {
    /**
     左右移动2个位置代价为0,任何奇数偶数都可以分别移动到同一个位置并且没有代价
     移动1个位置代价为1, 奇<-->偶 的代价都为1
     统计奇偶数的个数包含重复, 将数量较小的全部移动到较大那一边
     移动的次数为较小的奇(偶)数量包含重复
     */
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for(int i:position){
            if(i%2==0){
                even++;
            }else{
                odd++;
            }
        }
        int move = odd>even?even:odd;
        return move;
    }
}
