package JZOffer.jz0304;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。



示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]


限制：

1 <= target <= 10^5
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/4 15:32
 */
public class jz57_II {

    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        //初始窗口左右端点i,j
        int i=1;
        int j=2;
        //初始序列和
        int s=3;
        List<int[]> res = new ArrayList<>();
        while(i<j){
            //序列和等于目标
            if(s==target){
                //创建连续序列数组
                int[] temp = new int[j-i+1];
                for(int k=i; k<=j; ++k){
                    temp[k-i] = k;
                }
                res.add(temp);
            }
            //当前序列和大于等于目标.左端点右移一位
            if(s>=target){
                //更新序列和
                s -= i;
                ++i;
            }else if(s<target){
                //当前序列和小于目标,右端点右移一位,
                ++j;
                //更新序列和
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
