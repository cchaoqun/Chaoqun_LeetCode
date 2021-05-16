package GreedyAlgorithm.greedy0430;

import java.util.*;
import java.util.Map.Entry;

/**
 * 1282. 用户分组
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 *
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释：
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 * 示例 2：
 *
 * 输入：groupSizes = [2,1,3,3,3,2]
 * 输出：[[1],[0,5],[2,3,4]]
 *
 *
 * 提示：
 *
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/30-17:06
 */

public class LC1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        //key:对应分组大小 value=对应分组大小的id
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int size = groupSizes.length;
        for(int i=0; i<size; i++){
            //当前用户所在分组大小
            int group = groupSizes[i];
            //当前分组大小未创建
            if(map.get(group)==null){
                //添加list
                map.put(group, new ArrayList<>());
                //当前用户id加入对应分组大小的list
                map.get(group).add(i);
            }else if(map.get(group).size()==group){
                //当前分组大小已满,
                //比如分组大小为3, 但是之前已经有3个,
                //将之前已经满了的加入res
                res.add(map.get(group));
                //将对应的分组大小添加新的list
                map.put(group, new ArrayList<>());
                //当前id加入list
                map.get(group).add(i);
            }else{
                //可以直接加入
                map.get(group).add(i);
            }
        }
        //遍历剩余已经满了但是还没加入res的分组大小
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if(!entry.getValue().isEmpty()){
                res.add(entry.getValue());
            }
        }
        return res;
    }
}

class LC1282_M2{
    //优先队列
    public List<List<Integer>> groupThePeople(int[] groupSizes){
        int len = groupSizes.length;
        //按照数组的第一个元素升序排列
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o->o[0]));
        List<List<Integer>> res = new ArrayList<>();
        //将所有分组大小 已经对应id放入优先队列
        for (int i = 0; i < len; i++) {
            minHeap.add(new int[]{groupSizes[i], i});
        }
        while(!minHeap.isEmpty()){
            //当前分组大小
            int cur = minHeap.peek()[0];
            List<Integer> curGroup = new ArrayList<>();
            for(int i=0; i<cur; i++){
                curGroup.add(minHeap.poll()[1]);
            }
            res.add(curGroup);
        }
        return res;
    }
}

































