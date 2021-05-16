package GreedyAlgorithm.greedy0509;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-20:49
 */

public class LC1743 {


    @Test
    public void test(){
        int[][] test = {
                {2,1},
                {3,4},
                {3,2}
        };
        int[] res = restoreArray(test);
        System.out.println(Arrays.toString(res));

    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        //获取二维数组的邻接表
        for(int[] level:adjacentPairs){
            int n1 = level[0];
            int n2 = level[1];
            if(map.get(n1)==null){
                map.put(n1, new ArrayList<>());
            }
            if(map.get(n2)==null){
                map.put(n2, new ArrayList<>());
            }
            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }
        int len = adjacentPairs.length;
        int[] res = new int[len+1];
        //找到一个起点
        for(int key:map.keySet()){
            if(map.get(key).size()==1){
                res[0] = key;
                break;
            }
        }
        //依次赋值
        for(int i=1; i<res.length; i++){
            if(map.containsKey(res[i-1])){
                //查看前一个元素对应的相邻元素的list
                for(int num:map.get(res[i-1])){
                    //如果其中的元素存在于map
                    if(map.containsKey(num)){
                        res[i] = num;
                        break;
                    }
                }
                //删除前一个元素对应的key-value对
                //因为前一个元素的左右元素都已经确认了
                map.remove(res[i-1]);
            }
        }
        return res;
    }
}
