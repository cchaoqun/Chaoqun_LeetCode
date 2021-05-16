package GreedyAlgorithm.greedy0515;

import org.junit.jupiter.api.Test;

/**
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 通过次数35,948提交次数71,686
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/15-11:31
 */

public class LC739 {
    public int monotoneIncreasingDigits(int n) {
        //数字转换成每位数字对应的字符数组
        char[] arr = Integer.toString(n).toCharArray();

        int i = 1;
        //从最高位开始,遍历每一位数字, 查看是否满足递增
        for(;i<arr.length && arr[i-1]<=arr[i]; i++){
        }
        //当前i位于第一位小于前一位的位置最高位从0开始 arr[i]<arr[i-1]
        if(i<arr.length){
            //前面[0,i-1]位已经确保非递减, 最坏情况为相等
            //将[i,arr.length-1]全部置为9
            //[0,i-1]位逐渐-1
            //找到第一位满足arr[i]-1>=arr[i-1],这样满足非递减
            while(i>0 && arr[i-1]>arr[i] ){
                arr[i-1] -= 1;
                i--;
            }
            //将i后面的位数全部置为9
            for(i+=1; i<arr.length; i++){
                arr[i] = '9';
            }
        }
        return Integer.parseInt(new String(arr));

    }
}

class LC739_M2{
    public int monotoneIncreasingDigits(int n){
        char[] arr = Integer.toString(n).toCharArray();
        //找到最大数对应的最小的下标maxId
        int max = -1;
        int maxId = -1;
        //因为总是比较arr[i] arr[i+1] 遍历到倒数第二个数即可
        for(int i=0; i<arr.length-1; i++){
            if(max<arr[i]){
                max = arr[i];
                maxId = i;
            }
            //发现逆序的情况
            //max前面的情况可能是
            // 1. maxId==i arr[maxId-1] < arr[maxId], 这时arr[maxId]--, 从maxId开始全部变成9即可
            // 2. maxId<i && arr[maxId]==arr[maxId+1]==...==arr[i],即maxId是当前非递减序列中最大数的最小下标
            //     这时, 将arr[maxId]--, [maxId, arr.length-1]变成'9'即可

            if(arr[i]>arr[i+1]){
                arr[maxId]--;
                for(int j=maxId+1; j<arr.length; j++){
                    arr[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(arr));

    }

    @Test
    public void test(){
        monotoneIncreasingDigits(2333332);
    }

}









