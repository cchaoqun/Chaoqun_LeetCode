package Heap.heap0224;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/3-15:10
 */

public class LC451 {
    public String frequencySort(String s) {
        //key=字符, value=字符在s中出现的次数
        Map<Character, Integer> map = new HashMap<>();
        //大顶堆, 按照Node.count从大到小
        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2)->o2.count-o1.count);
        //统计每个字符出现的次数
        for(char cur:s.toCharArray()){
            map.put(cur, map.getOrDefault(cur,0)+1);
        }
        //遍历每个字符创建对应Node对象放入heap
        for(char cur:map.keySet()){
            heap.offer(new Node(cur, map.get(cur)));
        }
        //拼接字符串
        StringBuffer sb = new StringBuffer();
        //所有Node按照字符出现次数从大到小出堆, 拼接对应次数的字符到sb
        while(!heap.isEmpty()){
            Node cur = heap.poll();
            int temp = cur.count;
            char cha = cur.c;
            while(temp>0){
                sb.append(cha);
                temp--;
            }
        }
        return sb.toString();
    }
}
//新建类保存 字符和出现的次数
class Node{
    public char c;
    public int count;
    public Node(){
    }
    public Node(char c, int count){
        this.c = c;
        this.count = count;
    }
}
