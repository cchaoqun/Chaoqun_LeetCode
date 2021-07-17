package vo;

import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/29-8:07
 */

public class VO1 {

    //TODO LC1509
    //TODO LC1525
    //TODO LC1438
    public int numSplits(String s) {
        int n = s.length();
        boolean[] left = new boolean[26];
        boolean[] right = new boolean[26];
        int[] leftPre = new int[n+2];
        int[] rightPre = new int[n+2];
        //从左到右 找到i位置结束, 左边子串中不同字符的个数
        for(int i=1; i<=n; i++){
            int c = s.charAt(i-1)-'a';
            //左边出现过
            if(left[c]){
                leftPre[i] = leftPre[i-1];
            }else{
                //左边没出现
                left[c] = true;
                leftPre[i] = leftPre[i-1]+1;
            }
        }
        //从右到左, 找到i位置开始, 右边子串中不同字符的个数
        for(int i=n; i>0; i--){
            int c = s.charAt(i-1)-'a';
            //右边出现过
            if(right[c]){
                rightPre[i] = rightPre[i+1];
            }else{
                //右边没出现
                right[c] = true;
                rightPre[i] = rightPre[i+1]+1;
            }
        }
        int res = 0;
        for(int i=1; i<n; i++){
            //i位置左边和i+1右边不同字符出现个数相同
            if(leftPre[i] == rightPre[i+1]){
                res++;
            }
        }
        return res;

    }

}
