package Heap.heap0224;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/3-15:36
 */

public class LC347 {
    //O(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //按照元素出现次数从大到小排列
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2)->map.get(o2)-map.get(o1));
        //统计元素出现次数
        for(int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        //所有元素放入堆
        for(int index:map.keySet()){
            heap.offer(index);
        }
        //出堆前k个高频元素
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = heap.poll();
        }
        return res;

    }
}
class LC347_M2{
    //O(nlogk)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //按照元素出现次数从小到大排列
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        //统计元素出现次数
        for(int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        //维护k个元素的堆
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            //已经有k个元素
            if(heap.size()==k){
                //只有当当前元素的出现次数大于对应元素出现次数,
                if(entry.getValue()>heap.peek()[1]){
                    //堆顶元素出堆
                    heap.poll();
                    //当前元素入堆
                    heap.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }else{
                //堆中元素不满k直接入堆
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        //出堆前k个高频元素
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = heap.poll()[0];
        }
        return res;
    }
}

class LC347_M3{
    //桶排序
    public int[] topKFrequent(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //统计频率
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        //list[i] 保存了出现i次的元素的集合
        List<Integer>[] list = new List[nums.length+1];
        for(int key:map.keySet()){
            int cur = map.get(key);
            if(list[cur]==null){
                list[cur] = new ArrayList<>();
            }
            list[cur].add(key);
        }
        //从出现次数大到小
        for(int i=nums.length; i>=0 && res.size()<k; i--){
            if(list[i]!=null){
                res.addAll(list[i]);
            }
        }
        //转换成数组
        int[] arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}