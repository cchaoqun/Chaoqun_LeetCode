package DynamicProgram.dp0115;

import java.util.List;

/*
 * @Description: 120. 三角形最小路径和
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
*
示例 1：
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为11（即，2+3+5+1= 11）。
*
示例 2：
输入：triangle = [[-10]]
输出：-10

提示：
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 16:47
 */
public class LC120 {
    //dp 直接在原数组上改变,每个位置改变后变成从顶点到该点的最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        //三角行
        int size = triangle.size();
        if(size==0){
            return 0;
        }
        if(size==1){
            return triangle.get(0).get(0);
        }
        int minPath = 0;
        for(int i=1; i<size; i++){
            //第i行列表的大小
            int rowSize = triangle.get(i).size();
            for(int j=0; j<rowSize; j++){
                int preMin = 0;
                int curr = 0;
                //每一行的第一个位置只能是上一个行的第一个位置走过来
                if(j==0){
                    preMin = triangle.get(i-1).get(j);
                }else if(j==rowSize-1){
                    //每一行的最后一个位置只能由上一行的最后一个位置走过来
                    preMin = triangle.get(i-1).get(j-1);
                }else{
                    //不是第一个或最后一个位置
                    //该位置的最小路径和是上一行该位置和该位置前面一个位置的最小值加上当前位置的值
                    //上一行能到该位置的最小路径和的较小值
                    preMin = Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j));
                }
                //当前位置最小路径和
                curr = triangle.get(i).get(j) + preMin;
                //替换
                triangle.get(i).set(j,curr);
                //如果到达最后一行
                if(i==size-1){
                    if(j==0){
                        //最后一行第一个元素
                        minPath = curr;
                    }
                    if(curr<minPath){
                        minPath = curr;
                    }
                }
            }
        }
        return minPath;
    }

    //dp 用一个一维数组
//    public int minimumTotal(List<List<Integer>> triangle){
//        int size = triangle.size();
//        if(size==0){
//            return 0;
//        }
//        int[] minPath = new int[size];
//        minPath[0] = triangle.get(0).get(0);
//        for(int i=1; i<size; i++){
//            //从每一行的最后一个位置往前覆盖,这样不会影响取到上一行对应位置的值
//            //确定本行最后一个位置的
//            minPath[i] = minPath[i-1] + triangle.get(i).get(i);
//            //确定本行中间位置的值
//            for(int j=i-1; j>0; j--){
//                minPath[j] = Math.min(minPath[j-1], minPath[j]) + triangle.get(i).get(j);
//            }
//            //确定本行第一个位置的值
//            minPath[0] += triangle.get(i).get(0);
//        }
//        Arrays.sort(minPath);
//        return minPath[0];
//    }
}
