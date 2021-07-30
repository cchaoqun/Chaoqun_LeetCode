package Algorithm_HW.Advanced.sweep_line;

import java.util.ArrayDeque;
import java.util.Deque;

/**1871. 跳跃游戏 VII
 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：

 i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 s[j] == '0'.
 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。



 示例 1：

 输入：s = "011010", minJump = 2, maxJump = 3
 输出：true
 解释：
 第一步，从下标 0 移动到下标 3 。
 第二步，从下标 3 移动到下标 5 。
 示例 2：

 输入：s = "01101110", minJump = 2, maxJump = 3
 输出：false


 提示：

 2 <= s.length <= 105
 s[i] 要么是 '0' ，要么是 '1'
 s[0] == '0'
 1 <= minJump <= maxJump < s.length
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/26-17:13
 */

public class JumpGameVII {
    /**
     本质是图问题, 字符串的每个0都是点, [i+minJump, i+maxJump] 中间的0都是neighbor
     BFS超时
     */
    public boolean canReach(String s, int minJump, int maxJump) {
        Deque<Integer> queue = new ArrayDeque<>();
        int l = minJump;
        int r = maxJump;
        int len = s.length();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur==len-1){
                return true;
            }
            for(int i=cur+l; i<=cur+r && i<len; i++){
                if(s.charAt(i)=='0'){
                    queue.offer(i);
                }
            }
        }
        return false;
    }
}

class JumpGameVII_M2{
    /**
     * 扫描线
     * i+minJump i可以到达这个区间
     * i+maxJump+1 i 不可以到达这个位置
     *
     * @param s
     * @param minJump
     * @param maxJump
     * @return
     */
    public boolean canReach(String s, int minJump, int maxJump){
        if(s.charAt(s.length()-1)=='1'){
            return false;
        }
        int len =s.length();
        int current = 0;
        int[] diff = new int[s.length()+1];
        //这里可达
        diff[0+minJump] = 1;
        //这里不可达
        diff[0+maxJump+1] = -1;
        for(int i=1; i<len; i++){
            current += diff[i];
            if(current==0){
                continue;
            }
            if(s.charAt(i)=='1'){
                continue;
            }
            if(i+minJump<=len){
                diff[i+minJump]++;
            }
            if(i+maxJump+1<=len){
                diff[i+maxJump+1]--;
            }
        }
        return current>0;
    }
}































