package company.bytedance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/23-17:27
 */

public class LC15 {

    @Test
    public void test(){
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length<3){
            return list;
        }
        //排序
        Arrays.sort(nums);
        int len = nums.length;
        //三指针 p1最左指针
        for(int p1 = 0;p1<len-1; p1++ ){
            //剪枝, 保证每次起始的值不同
            if(p1>0 && nums[p1]==nums[p1-1]){
                continue;
            }
            //如果nums[p1]>0 三数之和一定大于0
            if(nums[p1]>0){
                return list;
            }
            //第二个指针
            int p2=p1+1;
            //第三个指针
            int p3=len-1;
            //两个指针不遇到
            while(p2<p3){
                //当前三数之和
                int curSum = nums[p1]+nums[p2]+nums[p3];
                //保证第二个指针每次的值都不同 否则剪枝
                if(p2>p1+1 && nums[p2]==nums[p2-1]){
                    p2++;
                    continue;
                }
                //当前和的情况
                if(curSum==0){
                    //添加对应的三个数
                    List<Integer> curList = new ArrayList<>();
                    curList.add(nums[p1]);
                    curList.add(nums[p2]);
                    curList.add(nums[p3]);
                    list.add(curList);
                    p2++;
                    p3--;
                }else if(curSum<0){
                    //第二指针右移 尝试让和增大
                    p2++;
                }else{
                    //第三指针左移尝试让和减小
                    p3--;
                }
            }

        }
        return list;
    }
}
