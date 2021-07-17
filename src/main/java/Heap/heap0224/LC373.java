package Heap.heap0224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/9-11:06
 */

public class LC373 {
    //O(n^2) 优先队列, 所有可能的组合 pop出前k个
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        //大根堆
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>((o1, o2)->(o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1)));
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                //当前组合的list
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                //heap元素不足k个直接放入
                if(heap.size()<k){
                    heap.offer(list);
                }else{
                    //heap元素=k, 比较堆顶的元素和, 如果当前更小就堆顶出堆, 当前组合入堆
                    if(list.get(0)+list.get(1)<heap.peek().get(0)+heap.peek().get(1)){
                        heap.poll();
                        heap.offer(list);
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        while(k>0 && !heap.isEmpty()){
            list.add(0,heap.poll());
            k--;
        }
        return list;
    }
}

class LC373_M2{
    //指针数组, 维护nums1每个元素指向的下一个nums2数组中元素的下标
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        //ptr[i]表示 nums1[i]与nums[ptr[i]]组合的和在nums1[i]与所有的nums2[]中的元素组合的最小值
        int[] ptr = new int[n1];
        while(res.size()<k){
            //默认当前nums1[]中与nums2中元素组合的最小和是nums1[min]对应的元素
            int min = 0;
            for(int i=1; i<n1; i++){
                if(ptr[i]==n2){
                    //nums1[i]对应到nums2[ptr[i]] nums1[i]已经对应过nums2[]中所有的元素了
                    continue;
                }
                //找出每个nums1中的元素与当前nums2中对应元素的和的最小值
                //ptr[min]==n2 当前最小的哪个组合 nums2[]中的元素已经全部遍历完了
                if(ptr[min]==n2 || nums1[min]+nums2[ptr[min]]>nums1[i]+nums2[ptr[i]]){
                    min = i;
                }
            }
            //遍历完了
            if(ptr[min]==n2){
                break;
            }
            //对应组合放入res
            res.add(Arrays.asList(nums1[min], nums2[ptr[min]]));
            //nums1[min]下一个应该与nums[]中元素的组合下标为下一位
            ptr[min]++;
        }
        return res;
    }
}






























