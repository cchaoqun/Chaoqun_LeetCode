package Heap.heap0224;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/4-13:38
 */

public class LC692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        /*
        保存出现频率最高的前k个字符串, 所以保存大小为k的最小堆
        两个元素出现频率相同的时候, 较大的应该排在后面即靠近堆顶, 更可能被出现频率相同但较小的字符串替换掉
        出现频率不同的时候, 应该按照出现频率从小到大排列, 堆顶出现频率最小, 最容易被更高频率的字符串替换掉
        */
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2)->map.get(s1)==map.get(s2)?s2.compareTo(s1):map.get(s1)-map.get(s2));
        //统计字符串出现频率
        for(String cur:words){
            map.put(cur, map.getOrDefault(cur,0)+1);
        }
        //遍历map
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            /*
            pq大小已经满了, 判断当前字符串是否需要替换掉堆顶的字符串
            可以替换的条件为,当前元素出现频率大于堆顶元素 或者频率相同但是更小
            */
            int curCount = entry.getValue();
            String curStr = entry.getKey();
            //需要查看是否替换堆顶的元素
            if(pq.size()==k){
                //当前元素频率>堆顶元素           当前元素频率=堆顶元素 && 当前元素小于堆顶元素
                if(curCount>map.get(pq.peek()) || (curCount==map.get(pq.peek()) && curStr.compareTo(pq.peek())<0)){
                    pq.poll();
                    pq.offer(curStr);
                }
            }else{
                //pq.size()<k 直接放入堆
                pq.offer(curStr);
            }
        }
        //头插入结果的list
        while(!pq.isEmpty()){
            res.add(0, pq.poll());
        }
        return res;

    }
}
