package DynamicProgram.dp0315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Description: 368. 最大整除子集
给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。

如果有多个目标子集，返回其中任何一个均可。



示例 1:

输入: [1,2,3]
输出: [1,2] (当然, [1,3] 也正确)
示例 2:

输入: [1,2,4,8]
输出: [1,2,4,8]
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/15 20:41
 */
public class LC368 {
    public static void main(String[] args) {
        LC368 sol = new LC368();
        int[] nums = {3,4,6,8,12,16,32};
        List<Integer> res = sol.largestDivisibleSubset(nums);
        System.out.println(res);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0){
            return res;
        }
        int n = nums.length;
        int max = 0;
        //排序 如果num[i]能够整除某个整除list中的最大值,则能够整除所有元素
        Arrays.sort(nums);
        //end.get(i):以nums[i]结尾的最大的整除list
        List<List<Integer>> end = new ArrayList<>();
        for(int num:nums){
            //为每个nums[i]初始化一个list
            end.add(new ArrayList<>());
        }

        for(int i=0; i<n; ++i){
            //以nums[i]结尾的最大的整除集合
            List<Integer> curList = new ArrayList<>();
            //遍历此前所有nums[0,i-1]结尾的集合
            for(int j=0; j<i; ++j){
                //如果当前元素整除nums[j]
                //则nums[i]整除以nums[j]结尾的list中所有元素,
                //并且以nums[j]结尾的list更大
                if(nums[i] % nums[j] == 0 && curList.size()<end.get(j).size()){
                    curList = end.get(j);
                }
            }
            //将之前遍历到的能够整除的list添加到i位置的list中
            end.get(i).addAll(curList);
            //nums[i]添加进去
            end.get(i).add(nums[i]);
            //判断当前最大的整除集合大小
            if(end.get(i).size()>end.get(max).size()){
                max = i;
            }
        }
        return end.get(max);
    }
}
