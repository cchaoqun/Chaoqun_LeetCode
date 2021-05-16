package NumList.List0131;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例1：
输入：[3,2,3]
输出：3
*
示例2：
输入：[2,2,1,1,1,2,2]
输出：2

进阶：
尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/31 18:17
 */
public class LC169 {
    public static void main(String[] args) {
        int[] nums = {2,1,1,1,7,7,7,2,2,2,3,7,7,7,7,7,7,7,7,7,7,4,5,7,6,7,7,7,7,8,9,9,9,9,10,11};
        int res = majorityElement(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    //快速排序,超出时间限制
//    public static int majorityElement(int[] nums) {
//        //对数组进行快速排序
//        int minVal = nums[0];
//        int index = 0;
//        for(int i=0; i<nums.length-1; i++){
//            //假定每次遍历的第一个数就是最小值
//            minVal = nums[i];
//            index = i;
//            for(int j=i+1; j<nums.length; j++){
//                if(nums[j]<minVal){
//                    //遇到更小的就更新
//                    minVal = nums[j];
//                    index = j;
//                }
//            }
//            //每次将本轮最小值放到本轮遍历的起始点
//            if(index!=i){
//                //与本轮最小值的位置元素交换
//                nums[index] = nums[i];
//                nums[i] = minVal;
//            }
//        }
//        //排序完返回最中间位置的值一定是多数元素
//        return nums[nums.length/2];
//    }

    //调用Arrays.sort()API排序
//    public static int majorityElement(int[] nums){
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }

    //HashMap存储每个元素出现的个数
//    public static int majorityElement(int[] nums){
//        Map<Integer,Integer> map = new HashMap<>();
//        //遍历数组,元素存在则+1,否则添加进去,次数设为1
//        for(int i=0; i<nums.length; i++){
//            if(map.containsKey(nums[i])){
//                map.put(nums[i], map.get(nums[i])+1);
//            }else{
//                map.put(nums[i],1);
//            }
//        }
//
//        //遍历map
//        int majCount = -1;
//        int majNum = -1;
//        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//            if(majCount == -1 || majCount < entry.getValue()){
//                majCount = entry.getValue();
//                majNum = entry.getKey();
//            }
//
//        }
//        return majNum;
//    }

    //摩尔投票法
    public static int majorityElement(int[] nums){
        int candidate = nums[0], count=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == candidate){
                count += 1;
            }else if(count > 0){
                count -= 1;
            }else{
                //count==0
                //将当前值作为可能的结果
                candidate = nums[i];
                count += 1;
            }
        }
        return candidate;
    }

}
