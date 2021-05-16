package NumList.List0122;

import java.util.*;

/*
 * @Description:
 *
给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
*
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
*
示例 2：
输入：nums = []
输出：[]
*
示例 3：
输入：nums = [0]
输出：[]

提示：
0 <= nums.length <= 3000
-105 <= nums[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/22 17:48
 */
public class LC15 {


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if(len<3){
            return list;
        }
        for (int i=0; i<nums.length; ++i){
            Set<List<Integer>> set1 = twoSum(nums, -nums[i], i);
            if(set1.size() != 0){
                //对于set中的每一个list,都将当前元素添加到list
                for(List<Integer> list1:set1) {
                    list1.add(nums[i]);
                    Collections.sort(list1);
                    //去重
                    set.add(list1);
                }
            }
            //set1.size()==0 说明未找到对应组合
        }
        //将set中的list添加到list中
        list.addAll(set);
        return list;

    }

    // 找到除了 index对应下标以外的元素 两数之和等于 target
    public static Set<List<Integer>> twoSum(int[] nums, int target, int index){
        // map 存储(数组元素值,数组元素下标)
        Map<Integer,Integer> numMap = new HashMap<>();
        //对于每一个目标值可能有多重情况
        Set<List<Integer>> list = new HashSet<>();
        //去除index对应的元素
        int[] newNums = new int[nums.length-1];
        for(int i=0; i< index; ++i){
            newNums[i] = nums[i];
        }
        for(int i=index; i< newNums.length; ++i){
            newNums[i] = nums[i+1];
        }
        //将新数组的第一个元素以及对应下标放入map
        numMap.put(newNums[0], 0);
        for(int i=1; i<newNums.length; ++i){
            int temp = target - newNums[i];
            if(numMap.containsKey(temp)){
                //找到满足要求的两个元素和= target
                List<Integer> list1 = new ArrayList<>();
                //将两个元素添加到list中
                list1.add(newNums[i]);
                list1.add(temp);
                //排序后添加到set中,这样保证不重合
                Collections.sort(list1);
                list.add(list1);
            }
            numMap.put(newNums[i], i);
        }
        return list;

    }

    //三指针
    //first从0-length-1
    //second从first+1向右
    //third 从length-1向左
//    public List<List<Integer>> threeSum(int[] nums){
//        int n = nums.length;
//        Arrays.sort(nums);
//        List<List<Integer>> list = new ArrayList<List<Integer>>();
//        //枚举a
//        for(int first=0; first<n; ++first){
//            //找到下一个不相同的值,这样保证不重复
//            if(first>0 && nums[first] == nums[first-1]){
//                continue;
//            }
//            //枚举c
//            int third = n-1;
//            int target = -nums[first];
//            //枚举b
//            for(int second=first+1; second<n; ++second){
//                if(second>first+1 && nums[second] == nums[second-1]){
//                    continue;
//                }
//                while(second<third && nums[second] + nums[third] > target){
//                    third--;
//                }
//                //指针重合,不会满足 a+b+c = 0
//                if(second == third){
//                    break;
//                }
//                //找到
//                if(nums[second] + nums[third] == target){
//                    List<Integer> list1 = new ArrayList<>();
//                    list1.add(nums[first]);
//                    list1.add(nums[second]);
//                    list1.add(nums[third]);
//                    list.add(list1);
//                }
//            }
//        }
//        return list;
//    }
}
