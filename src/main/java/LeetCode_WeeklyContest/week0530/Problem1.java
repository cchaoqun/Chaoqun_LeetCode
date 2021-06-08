package LeetCode_WeeklyContest.week0530;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/30-10:29
 */

public class Problem1 {

    @Test
    public void test(){
        String n = "-13";
        int x = 2;
        String s = maxValue(n, x);
        System.out.println(s);

    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        return strToInt(firstWord)+strToInt(secondWord)==strToInt(targetWord);
    }

    private int strToInt(String str){

        int p = 0;
        while(p<str.length() && str.charAt(p)=='a'){
            p++;
        }
        int sum = 0;
        for(int i=p; i<str.length(); i++){
            sum += str.charAt(i)-'a';
            sum*=10;
        }
        return sum;
    }

    public String maxValue(String n, int x) {
        char[] arr = n.toCharArray();
        if(n.charAt(0)!='-'){
            int i = 0;
            while(i<arr.length && arr[i]-'0'>x){
                i++;
            }
            if(i==arr.length){
                return n+x;
            }else{
                return n.substring(0,i)+x+n.substring(i,n.length());
            }
        }else{
            int i=1;
            while(i<arr.length && arr[i]-'0'<x){
                i++;
            }
            if(i==arr.length){
                return n+x;
            }else{
                return n.substring(0,i)+x+n.substring(i,n.length());
            }
        }
    }

    @Test
    public void test1(){

        int[] servers = {31,96,73,90,15,11,1,90,72,9,30,88};
        int[] tasks = {87,10,3,5,76,74,38,64,16,64,93,95,60,79,54,26,30,44,64,71};
        int[] ints = assignTasks(servers, tasks);
        System.out.println(Arrays.toString(ints));
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        //服务器 任务 数组长度
        int n = servers.length;
        int m = tasks.length;
        //服务器队列, 按照
        //如果服务器的权重不等, 按照权重从小到大排列, 如果服务器权重相等 按照下标从小到大排列
        PriorityQueue<Integer> idle = new PriorityQueue<>(n, (i, j) -> servers[i] != servers[j] ? servers[i] - servers[j] : i - j);
        //busy的服务器, 按照重新空闲的时间从小到大排列
        //long[0] 服务器的下标, long[1]服务器的重新空闲时间
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        //等待的任务下标, 从小到大
        PriorityQueue<Integer> wait = new PriorityQueue<>();
        //初始 将所有服务器的下标放入队列
        for(int i=0; i<n; i++){
            idle.offer(i);
        }
        //当前的时间
        long time = 0;
        //存放服务器使用下标的结果数组
        int[] res = new int[m];
        //time从[0,m-1]
        for(int i=0; i<m; i++){
            time = i;

            //将所有busy服务器队列中当前时间已经空闲的服务器放入空闲队列
            while(!busy.isEmpty() && busy.peek()[1]<=time){
                //数组第一个元素代表重新空闲服务器在servers中的下标
                idle.offer((int)busy.poll()[0]);
            }
            //当前任务进入等待任务队列
            wait.offer(i);
            //空闲服务器不为空, 等待任务队列不为空
            while(!wait.isEmpty() && !idle.isEmpty()){
                //权重最小的服务器下标出队
                int serv = idle.poll();
                //最小任务下标出队
                int tid = wait.poll();
                //tid的任务有servers[serv]处理
                res[tid] = serv;
                //serv服务器运作, 在time+tasks[tid]时间重新空闲
                busy.add(new long[]{serv, time+tasks[tid]});

            }

        }
        //处理剩余等待的任务
        while(!wait.isEmpty()){
            //如果空闲服务器为空, 从下一个重新空闲的服务器时间开始 省去中间的时间
            if(idle.isEmpty()){
                time = busy.peek()[1];
            }
            //只要重新空闲时间<=当前时间的都出队(已经空闲了)
            while(!busy.isEmpty() && busy.peek()[1]<=time){
                //服务器下标
                long[] serv = busy.poll();
                //放入空闲服务器队列
                idle.offer((int)serv[0]);
            }
            //依次出队 服务器 和 任务 的下标
            while(!wait.isEmpty() && !idle.isEmpty()){
                //当前最小服务器下标
                int serv = idle.poll();
                //当前待处理任务下标
                int tid = wait.poll();
                //tid任务由serv服务器处理
                res[tid] = serv;
                //serv服务器重新busy
                busy.add(new long[]{serv, time+tasks[tid]});
            }
        }
        return res;
    }

}


