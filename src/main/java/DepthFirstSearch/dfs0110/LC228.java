package DepthFirstSearch.dfs0110;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 228. 汇总区间
 *
给定一个无重复元素的有序整数数组 nums 。
返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b

示例 1：
输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
*
示例 2：
输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
*
示例 3：
输入：nums = []
输出：[]
*
示例 4：
输入：nums = [-1]
输出：["-1"]
*
示例 5：
输入：nums = [0]
输出：["0"]
*
提示：
0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
nums 中的所有值都 互不相同
nums 按升序排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/summary-ranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 11:35
 */
public class LC228 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        List<String> res = summaryRanges(nums);
        System.out.println(res);
    }

    //自己方法
//    public static List<String> summaryRanges(int[] nums) {
//        int n = nums.length;
//        List<String> list = new ArrayList<>();
//        if(n==0){
//            return list;
//        }
//        if(n==1){
//            list.add(String.valueOf(nums[0]));
//            return list;
//        }
//        //双指针 i指向区间的起点,j指向终点
//        int i=0,j=1;
//        for(i=0; i<n; ){
//            for(j=i+1; j<n; ){
//                //nums[j] - nums[j-1] == 1
//                if(nums[j]-nums[j-1] == 1){
//                    //后移
//                    j++;
//                }else{
//                    //nums[j] - nums[j-1] > 1
//                    break;
//                }
//            }
//            //这一个区间为 [i,j-1]
//            //判断i==j-1
//            if(i==(j-1)){
//                list.add(nums[i]+"");
//            }else{
//                list.add(nums[i]+"->"+nums[j-1]);
//            }
//            //下一次i从j开始
//            i=j;
//        }
//        return list;
//    }

    //更简洁解法
    public static List<String> summaryRanges(int[] nums){
        List<String> list = new ArrayList<>();
        int i = 0;
        for(int j=0; j<nums.length; j++){
            //如果j达到数组末尾或者不满足练习递增,记录当前区间
            if(j+1 == nums.length || nums[j+1] != nums[j]+1){
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                //如果i!=j
                if(i!=j){
                    sb.append("->").append(nums[j]);
                }
                //将区间添加到list
                list.add(sb.toString());
                //下一次从j+1起始
                i = j+1;
            }
        }
        return list;
    }
}
