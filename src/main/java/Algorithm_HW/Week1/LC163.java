package Algorithm_HW.Week1;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. 缺失的区间
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 *
 * 示例：
 *
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/1-14:45
 */

public class LC163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //保存字符串的list
        List<String> res = new ArrayList<>();
        //表示如果连续, 当前数字应该为的数字
        int start = lower;
        String arrow = "->";
        //遍历数组
        for(int i=0; i<nums.length; i++){
            //如果当前数字不等于连续时当前位置应该为的数字, 中间缺失了一个区间
            if(nums[i]!=start){
                //StringBuffer 保存字符串
                StringBuffer sb = new StringBuffer();
                //首先把缺失的区间左端点放入sb
                sb.append(start);
                //如果nums[i]-1> 区间左端点, 区间内不止一个数字,
                //需要添加 "->" 和右端点为 nums[i]-1
                if(nums[i]-1>start){
                    sb.append(arrow).append(nums[i]-1);
                }
                //缺失区间添加到list
                res.add(sb.toString());
            }
            //无论当前数字是否为连续, 下一个数字都应该更新为当前数字+1
            start = nums[i]+1;
        }
        //遍历完以后处理可能存在的最后一个缺失区间
        //下一个连续的数如果<upper 还存在一个缺失的区间
        if(start<=upper){
            StringBuffer sb = new StringBuffer();
            //区间左端点
            sb.append(start);
            //区间左端点如果<upper说明缺失区间大小>1 右端点为upper
            if(start<upper){
                sb.append(arrow).append(upper);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
