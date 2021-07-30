package JZOffer.review;

import java.util.ArrayList;
import java.util.List;

/**剑指 Offer 57 - II. 和为s的连续正数序列
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
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/29-16:28
 */

public class jz57_II {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int index = 1;
        backtrack(res, index, target);
        return res.toArray(new int[res.size()][]);
    }

    private void backtrack(List<int[]> list, int index, int target) {
        //剪枝
        if (index > target / 2) {
            return;
        }
        //当前和
        int curSum = 0;
        int cur = index;
        //当前和的元素
        List<Integer> path = new ArrayList<>();
        while (curSum < target) {
            path.add(cur);
            curSum += cur;
            cur++;
        }
        //符合条件加入res
        if (path.size() > 1 && curSum == target) {
            list.add(path.stream().mapToInt(Integer::valueOf).toArray());
        }

    }
}

class jz57_II_M2{
    public int[][] findContinuousSequence(int target) {
        /**
         滑动窗口, 如果 sum[l,r]==target 更新path curSum
         <        r++ 更新path curSum
         >        更新path curSum l++

         */
        int l=1, r=2,curSum=3, limit = target/2+1;
        List<int[]> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(1);
        path.add(2);
        while(l<r){
            if(curSum==target){
                List<Integer> curArr = new ArrayList<>(path);
                res.add(curArr.stream().mapToInt(Integer::valueOf).toArray());
                path.remove(0);
                curSum-=l;
                l++;
            }else if(curSum<target){
                r++;
                path.add(r);
                curSum+=r;
            }else{
                path.remove(0);
                curSum-=l;
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }
    public int[][] findContinuousSequence(int target, int flag) {
        /**
         滑动窗口, 如果 sum[l,r]==target 更新path curSum
         <        r++ 更新path curSum
         >        更新path curSum l++

         */
        int l=1, r=2,curSum=3;
        List<int[]> res = new ArrayList<>();
        while(l<r){
            if(curSum==target){
                int[] cur = new int[r-l+1];
                for(int i=l; i<=r; i++){
                    cur[i-l] = i;
                }
                res.add(cur);
                curSum-=l;
                l++;
            }else if(curSum<target){
                r++;
                curSum+=r;
            }else{
                curSum-=l;
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}