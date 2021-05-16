package NumList.List0131;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @Description: 219. 存在重复元素 II
给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。


示例1:
输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/31 21:29
 */
public class LC219 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,};
        boolean res = containsNearbyDuplicate(nums,3);
        System.out.println(res);
    }

    //双层循环, 效率低
//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        int n = nums.length;
//        if(n<=1){
//            return false;
//        }
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<=i+k; j++){
//                if(j<n && nums[i] == nums[j]){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    //HashMap
    public static boolean containsNearbyDuplicate(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i],i);
            }
            //如果map大小超过k,删除最旧的元素,这样保证了每次比较的时候map里只有k个元素
            if(map.size()>k){
                map.remove(nums[i-k]);
            }
        }
        return false;
    }

    //HashSet
//    public static boolean containsNearbyDuplicate(int[] nums, int k){
//        Set<Integer> set = new HashSet<>();
//        for(int i=0; i<nums.length; i++){
//            if(set.contains(nums[i])){
//                return true;
//            }
//            set.add(nums[i]);
//            //保证每次比较的时候,set中只有k个元素
//            if(set.size()>k){
//                set.remove(nums[i-k]);
//            }
//        }
//        return false;
//    }



}
