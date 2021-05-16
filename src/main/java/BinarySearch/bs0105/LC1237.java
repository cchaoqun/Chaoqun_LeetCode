package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 1237. 找出给定方程的正整数解
给你一个函数f(x, y)和一个目标结果z，请你计算方程f(x,y) == z所有可能的正整数 数对x 和 y。

给定函数是严格单调的，也就是说：

f(x, y) < f(x + 1, y)
f(x, y) < f(x, y + 1)

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 12:16
 */
public class LC1237 {
    public static void main(String[] args) {

    }
    //暴力
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<=1000; i++){
            if(customfunction.f(i,1) > z){
                break;
            }
            for(int j=1; j<=1000; j++){
                if(customfunction.f(i,j) == z){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                    //单调,对于当前的 i 后面的j与i的组合一定>z
                    break;
                }else if(customfunction.f(i,j)>z){
                    break;
                }
            }
        }
        return res;
    }
/**
    //二分查找
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<=1000; i++){
            if(customfunction.f(i,1)>z){
                break;
            }
            int left = 0;
            int right = 1000;
            while(left<=right){
                int mid = (left+right)/2;
                int midVal = customfunction.f(i,mid);
                if(midVal == z){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(mid);
                    res.add(list);
                    break;
                }else if(z<midVal){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return res;
    }

    //双指针
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z){
        List<List<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 1000;
        while(left<=1000 && right>=1){
            int temp = customfunction.f(left,right);
            if( temp== z){
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                left++;
            }else if(temp>z){
                right--;
            }else{
                left++;
            }

        }
        return res;
    }
*/

    interface CustomFunction { // Returns positive integer f(x, y) for any given positive integer x and y.
        int f(int x, int y);
    };

}

