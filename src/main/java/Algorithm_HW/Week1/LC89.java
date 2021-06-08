package Algorithm_HW.Week1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/31-12:45
 */

public class LC89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        //必须以0开头
        list.add(0);
        //代表添加的最高位为数字
        int head = 1;
        for(int i=0; i<n; i++){
            //对于每个n, 逆序获取list中的数字
            //list中的数字已经是每隔一位相差1了
            //逆序在最高位+1后, 等于list数量变成了原来的两倍,
            //新添加的后半部分与前半部分的最后一位相差1 差别在最高位加了1
            //新的后半部分每个数字原本都是隔位差1, 并且最高位都加了1 所以保证了隔位差1
            for(int j=list.size()-1; j>=0; j--){
                //逆序从list中获取数字并在最高位+1
                list.add(list.get(j)+head);
            }
            head<<=1;
        }
        return list;


    }
}
