package JZOffer.jz0304;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/4 15:09
 */
public class jz57 {

    //HashMap 时间O(N) 空间O(N)
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i=0; i<nums.length; ++i){
//            int cur = nums[i];
//            int rest = target - cur;
//            if(map.containsKey(rest)){
//                return new int[]{cur, target-cur};
//            }else{
//                map.put(cur, i);
//            }
//        }
//        return new int[2];
//    }


    //排序数组,双指针, 空间O(1)
    public int[] twoSum(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int sum = 0;
        while(left<right){
            sum = nums[left]+nums[right];
            if(sum==target){
                return new int[]{nums[left], nums[right]};
            }
            else if(sum>target){
                --right;
            }else if(sum<target){
                ++left;
            }
        }
        return new int[2];
    }
}
