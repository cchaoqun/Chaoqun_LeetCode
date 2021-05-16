package DynamicProgram.dp0325;

import java.util.Arrays;

/*
 * @Description: 646. 最长数对链
给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。

现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。

给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。



示例：

输入：[[1,2], [2,3], [3,4]]
输出：2
解释：最长的数对链是 [1,2] -> [3,4]


提示：

给出数对的个数在 [1, 1000] 范围内。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/25 17:51
 */
public class LC646 {

    //dp
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        //根据数对的第一个数进行排序
        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);
        //dp[i] = 以排序后第i个数对结尾的最长数对链
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        //从第二个结尾开始
        for(int i=1; i<len; i++){
            //从头开始到i-1
            for(int j=0; j<i; j++){
                //遇到数对的第二个数小于结尾数对的第一个数,就可以放在数对链中
                if(pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        //遍历取最大长度
        int sum = 0;
        for(int i:dp){
            sum = Math.max(i, sum);
        }
        return sum;
    }
}
class LC646_M2{

    public int findLongestChain(int[][] pairs){
        int len = pairs.length;
        //以数对的第二个数排序
        Arrays.sort(pairs, (a,b) -> a[1]-b[1]);
        int cur = Integer.MIN_VALUE;
        int sum = 0;
        //遍历排序后的数对
        for(int i=0; i<len; i++){
            //如果当前[0:i-1]中数对链最后一个数对的第二个值小于当前数对第一个值,
            //当前数对可以加到数对尾部
            if(cur<pairs[i][0]){
                //更换当前数对尾的值
                cur = pairs[i][1];
                //数对链长度+1
                sum++;
            }
        }
        return sum;
    }



}
