package GreedyAlgorithm.greedy0122;

import java.util.Arrays;

/*
 * @Description: 135. 分发糖果
 *
老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：
每个孩子至少分配到 1 个糖果。
评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢
*
示例1：
输入：[1,0,2]
输出：5
解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
*
示例2：
输入：[1,2,2]
输出：4
解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/candy
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/22 15:05
 */
public class LC135 {

    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int res = candy(ratings);
        System.out.println(res);
    }
    //先给每个人发一个糖果
    //先从右向左遍历.只要ratings[i] > ratings[i-1] candy += 1
    //再从右向左遍历,只要ratings[i] > ratings[i+1] candy += 1
    public static int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0){
            return 0;
        }
        //每人至少一个糖果
        int[] candyLeft = new int[len];
        int[] candyRight = new int[len];
        Arrays.fill(candyLeft,1);
        Arrays.fill(candyRight,1);

        //满足左规则
        for(int i=1; i<len; ++i){
            if(ratings[i] > ratings[i-1]){
                candyLeft[i] = candyLeft[i-1] + 1;
            }
        }
        //满足右规则
        int max = candyLeft[len-1];
        for(int i=len-2; i>=0; --i){
            if(ratings[i] > ratings[i+1]){
                candyRight[i] = candyRight[i+1] + 1;
            }
            max += Math.max(candyLeft[i], candyRight[i]);
        }
        return max;
    }
}
