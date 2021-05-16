package NumList.List0130;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 119. 杨辉三角 II
给定一个非负索引k，其中 k≤33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/30 22:54
 */
public class LC119 {

    public static void main(String[] args) {
        List<Integer> res= getRow(3);
        System.out.println(res);

    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++){
            //新的一行数组元素增加1在末尾
            list.add(1);
            //从后往前更新数组元素
            for(int j=i-1; j>0; j--){
                list.set(j,list.get(j)+list.get(j-1));
            }
        }
        return list;
    }
}
