package Sort.sort0526;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/26-22:10
 */

public class LC1370 {
    public String sortString(String s) {
        int[][] count = new int[26][2];
        //统计每个字符出现的次数
        //count[i][0] 代表字符 0-25
        //count[i][1] 代表字符出现的次数
        for(char c:s.toCharArray()){
            count[c-'a'][0] = c-'a';
            count[c-'a'][1]++;
        }
        //双端队列
        Deque<int[]> queue1 = new LinkedList<>();
        Deque<int[]> queue2 = new LinkedList<>();
        //一开始将所有的数组按字符从小到大的添加入队列1
        for(int i=0;i<26; i++){
            if(count[i][1]>0){
                queue1.offer(count[i]);
            }
        }
        //保留最后的结果
        StringBuffer sb = new StringBuffer();
        //两个队列不全为空
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            //如果存在某个队列只剩一个数组, 就将这个数组对应的字符添加对应次数并返回
            //因为每次只有一个队列有数组
            if(queue1.size()==1 || queue2.size()==1){
                int[] cur = queue1.size()==1?queue1.poll():queue2.poll();
                while(cur[1]>0){
                    sb.append((char)(cur[0]+'a'));
                    cur[1]--;
                }
                return sb.toString();
            }
            //每次将一个队列的数组addFirst()到另外一个队列, 这样下次遍历另外一个队列就是逆序的
            if(queue2.isEmpty()){
                while(!queue1.isEmpty()){
                    int[] cur = queue1.poll();
                    char c = (char)(cur[0]+'a');
                    sb.append(c);
                    cur[1]--;
                    if(cur[1]>0){
                        queue2.addFirst(cur);
                    }
                }
            }else{
                while(!queue2.isEmpty()){
                    int[] cur = queue2.poll();
                    char c = (char)(cur[0]+'a');
                    sb.append(c);
                    cur[1]--;
                    if(cur[1]>0){
                        queue1.addFirst(cur);
                    }
                }
            }
        }
        return sb.toString();
    }
}

class LC1370_M2{
    public String sortString(String s){
        int[] count = new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        while(len>0){
            for(int i=0; i<26; i++){
                if(count[i]>0){
                    sb.append((char)(i+'a'));
                    --count[i];
                    len--;
                }
            }
            for(int i=25; i>=0; i--){
                if(count[i]>0){
                    sb.append((char)(i+'a'));
                    --count[i];
                    len--;
                }
            }
        }
        return sb.toString();
    }
}















