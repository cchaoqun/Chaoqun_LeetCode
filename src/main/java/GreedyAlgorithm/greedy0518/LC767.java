package GreedyAlgorithm.greedy0518;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/18-22:38
 */

public class LC767 {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        //获取每个字符的数量
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        //list存放alpha对象(alpha中包含属性c为字符, num c字符在字符串中出现的次数
        List<alpha> list = new ArrayList<>();
        for(int i=0; i<26; i++){
            if(count[i]!=0){
                //队友出现的字符创建对应对象并存放进去
                list.add(new alpha((char)('a'+i), count[i]));
            }
        }
        //按照出现次数从大到小排序
        Collections.sort(list, (o1, o2)->o2.num-o1.num);
        //所有alpha对象按顺序入队
        Deque<alpha> queue = new LinkedList<>();
        for(alpha a:list){
            queue.offer(a);
        }
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()){
            //出队
            alpha cur = queue.poll();
            //如果当前字符剩余次数>=2, 没有其他字符了, 一定会相同
            if(cur.num>1 && queue.isEmpty()){
                return "";
            }
            //当前字符还需要出现在字符串中
            if(cur.num!=0){
                //剩余次数-1
                cur.num--;
                //添加到字符串中
                sb.append(cur.c);
                //如果当前字符剩余次数大于队列顶部字符出现次数, 将当前字符放在队列第二个位置, 因为需要先尽可能把出现次数多的字符放进去
                //通过队列顶部元素先出队, 当前元素放入队列顶端, 之前的栈顶元素再放入队列顶部
                if(cur.num>queue.peekFirst().num){
                    alpha top = queue.poll();
                    queue.addFirst(cur);
                    queue.addFirst(top);
                    continue;
                }else{
                    //当前字符出现次数<=队列头的字符次数, 当前字符放入队列尾
                    if(cur.num!=0){
                        queue.offer(cur);
                    }
                }

            }
        }
        return sb.toString();

    }
}
class alpha{
    char c;
    int num;

    public alpha(){

    }

    public alpha(char c, int num){
        this.c =c;
        this.num=num;
    }
}
//基于最大堆的贪心
class LC767_M2{
    public String reorganizeString(String s){
        int[] count = new int[26];
        int maxCount = 0;
        for(char c:s.toCharArray()){
            count[c-'a']++;
            maxCount = Math.max(maxCount, count[c-'a']);
        }
        //判断能否重新排列, 如果出现的最大次数> (n+1)/2 不可以
        if(maxCount>(s.length()+1)/2){
            return "";
        }
        //可以重排, 维护大顶堆, 按照字符出现次数从大到小排列
        PriorityQueue<Character> heap = new PriorityQueue<Character>((o1,o2)->count[o2-'a']-count[o1-'a']);
        //将所有出现的字符入堆
        for(char c='a'; c<='z'; c++){
            if(count[c-'a']>0){
                heap.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(heap.size()>1){
            //一次出队两个
            char c1 = heap.poll();
            char c2 = heap.poll();
            sb.append(c1);
            sb.append(c2);
            int n1 = c1-'a';
            int n2 = c2-'a';
            count[n1]--;
            count[n2]--;
            if(count[n1]>0){
                heap.offer(c1);
            }
            if(count[n2]>0){
                heap.offer(c2);
            }

        }
        if(heap.size()==1){
            sb.append(heap.poll());
        }
        return sb.toString();
    }
}
//基于计数的贪心
class LC767_M3{
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        int maxCount = 0;
        int maxIndex = 0;

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if(count[c-'a']>maxCount){
                maxCount = count[c-'a'];
                maxIndex = c-'a';
            }
        }
        //判断能否重新排列, 如果出现的最大次数> (n+1)/2 不可以
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        //可以重排, 维护大顶堆, 按照字符出现次数从大到小排列
        PriorityQueue<Character> heap = new PriorityQueue<Character>((o1, o2) -> count[o2 - 'a'] - count[o1 - 'a']);
        //将所有出现的字符入堆
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) {
                heap.offer(c);
            }
        }
        char[] cha = new char[n];
        //出现最多的放在偶数位置
        int index=0;
        char maxChar = (char)('a'+maxIndex);
        for(; index<n && count[maxIndex]>0; index+=2){
            cha[index] = maxChar;
            count[maxIndex]--;
        }

        for(int i=0; i<26; i++){
            while(count[i]-- > 0){
                if(index>=n){
                    index = 1;
                }
                cha[index] = (char)(i+'a');
                index+=2;
            }
        }
        return new String(cha);
    }
}



































