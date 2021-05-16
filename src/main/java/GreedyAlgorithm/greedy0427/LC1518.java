package GreedyAlgorithm.greedy0427;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/27-18:31
 */

public class LC1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        //剩余空瓶子
        int remBottles = 0;
        //剩下的空瓶子和有酒的瓶子数量加起来还可以换酒
        while(numBottles+remBottles>=numExchange){
            //全部喝完
            count += numBottles;
            //空瓶子数量+喝完的瓶子
            remBottles += numBottles;
            //可以换的酒
            numBottles = remBottles/numExchange;
            //剩下的空瓶子
            remBottles = remBottles%numExchange;
        }
        //最后可能还剩下没喝的酒
        return count+numBottles;
    }
}
