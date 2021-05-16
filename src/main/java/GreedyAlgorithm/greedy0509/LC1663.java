package GreedyAlgorithm.greedy0509;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-20:25
 */

public class LC1663 {
    public String getSmallestString(int n, int k) {

        StringBuilder sb = new StringBuilder();
        while(n>0){
            //剩余需要的和 - 剩余字符最大和
            int cur = k-(n-1)*26;
            if(cur<=0){
                //当前取a不影响
                sb.append('a');
                //a=1
                k -= 1;
            }else{
                //当前必须取的最小值使得剩余字符最大和可以满足剩余需要的和
                sb.append((char)(97+cur-1));
                //当前字符代表的大小
                k -= cur;
            }
            n--;
        }
        return sb.toString();
    }
}
