package GreedyAlgorithm.greedy0516;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/16-18:55
 */

public class LC842 {

    @Test
    public void test(){
        String s = "123456579";
        System.out.println(s);
        List<Integer> res = splitIntoFibonacci(s);
        System.out.println("最后的结果: "+res);
    }

    public List<Integer> splitIntoFibonacci(String S){
        char[] arr = S.toCharArray();
        int len = arr.length;
        List<Integer> res = new ArrayList<>();
        dfs(res, arr, len, 0);
        return res;

    }

    boolean dfs(List<Integer> res, char[] arr, int len, int start){
        //所有数字已经添加到res, 并且数量>=3
        if(start==len && res.size()>=3){
            return true;
        }
        for(int i=start; i<len; i++){
            //剪枝1:两位以上的数字不能以0开头
            if(arr[start]=='0' && i>start){
                break;
            }
            //获取当前的数字
            long cur = slice(arr, start, i);
            if(cur>Integer.MAX_VALUE){
                break;
            }

            int size = res.size();
            //剪枝2:res中已经有>=2个数字 并且cur>res中最后两个数的和
            if(res.size()>=2 && cur>res.get(size-1)+res.get(size-2)){
                break;
            }
            //当前数字可以添加进res的情况
            //1. res.size()<=1
            //2. res中最后两个数的和== cur
            if(res.size()<=1 || cur== (res.get(size-1)+res.get(size-2))){
                res.add((int)cur);
                System.out.println("递归前:"+res);
                //递归的去找下一个数
                if(dfs(res, arr, len, i+1)){
                    System.out.println("找到了: "+res);
                    //找到了就返回
                    return true;
                }
                //递归回来不符合条件的需要本次添加的数, 继续扩大当前这个数
                res.remove(res.size()-1);
                System.out.println("递归后:"+res);
            }
        }
        return false;
    }

    long slice(char[] arr, int start, int index){
        long res = 0;
        for(int i=start; i<arr.length && i<=index; i++){
            res *= 10;
            res += arr[i]-'0';
        }
        return res;
    }
}
