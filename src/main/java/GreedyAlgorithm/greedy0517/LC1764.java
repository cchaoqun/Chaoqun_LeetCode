package GreedyAlgorithm.greedy0517;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/17-16:06
 */

public class LC1764 {

    @Test
    public void test(){
        int[][] groups = {{-5,0}};
        int[] nums = {2,0,-2,5,-1,2,4,3,4,-5,-5};
        boolean res = canChoose(groups, nums);
        System.out.println(res);

    }

    public boolean canChoose(int[][] groups, int[] nums) {
        return dfs(groups, nums, 0, 0);
    }

    public boolean dfs(int[][] groups, int[] nums, int start, int level){
        //level = groups.length
        //level-1个数组已经匹配完成, 说明全部匹配完
        if(level==groups.length){
            return true;
        }
        //level<nums.length 但是 起始匹配的索引已经超出了nums的下标范围, 不会匹配完成
        if(start>=nums.length){
            return false;
        }
        //当前groups[level]中元素与nums[start]开始连续匹配的个数
        int match = 0;
        //   从nums[start]开始匹配          匹配的数量<当前group[level]的数量
        for(int i=start; i<nums.length && i<groups[level].length+start; i++){
            //当前数字不相等, 从start+1继续匹配这一个group[level]
            if(nums[i]!=groups[level][i-start]){
                return dfs(groups, nums, start+1, level);
            }
            //当前nums[i] == groups[level][i-start] 匹配到的个数+1
            match++;
        }
        if(match==groups[level].length){
            //当前group[level]匹配完成, 继续匹配数组group[level+1]
            return dfs(groups, nums, groups[level].length+start, level+1);
        }else{
            //当前匹配不成功, 说明不能匹配
            return false;
        }

    }
}

class LC1764_M2{
    public boolean canChoose(int[][] groups, int[] nums){
        int m = groups.length;
        int len = nums.length;
        int start = 0;
        int i = 0;
        //遍历每一个groups[i]的匹配情况
        for(; i<m && start<len;){
            //当前groups[i]匹配
            if(match(groups, nums, start, i, len)){
                //下一个开始匹配的下标为start+groups[i].length
                start += groups[i].length;
                //继续下一个数组的匹配
                i++;
            }else{
                //继续匹配当前groups[i]
                start++;
            }
        }
        //匹配的个数是否等于groups.length
        return i==m;

    }
    //从b[start]开始是否匹配了a[level]
    boolean match(int[][] a, int[] b, int start, int level, int len){
        int match = 0;
        for(int i=start; i<a[level].length+start && i<len ; i++){
            if(a[level][i-start]!=b[i]){
                return false;
            }
            ++match;
        }
        return match==a[level].length;
    }
}
