package NumList.List0131;

import java.util.TreeSet;

/*
 * @Description: 220. 存在重复元素 III
在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。

如果存在则返回 true，不存在返回 false。



示例 1:

输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1, t = 2
输出: true
示例 3:

输入: nums = [1,5,9,1,5,9], k = 2, t = 3
输出: false
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/25 12:48
 */
public class LC220 {

    //滑动窗口查找表 nums[i] - nums[j] <= t   -k<= i-j <=k
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        //滑动窗口查找表
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0; i<nums.length; ++i){
            //查找表中是否有>=nums[i]-t <=nums[i]+t的数字
            Long ceiling = set.ceiling((long)nums[i]-(long)t);
            if(ceiling != null && ceiling<=((long)nums[i]+(long)t)){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size()==k+1){
                //移除窗口最左边的元素
                set.remove(nums[i-k]);
            }

        }
        return false;
    }
}
