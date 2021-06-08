package Algorithm_HW.Week2;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/5-11:34
 */

public class LC718 {
    public int findLength(int[] A, int[] B) {
        /*
        本质是滑动窗口, 两个数组先对齐
        A先向左滑动,起始的坐标从0->A.length-1, B保持不动, 比较对应位置是否相等并求出最长连续匹配长度
        重新对齐
        B向左滑动, 起始的坐标从0->B.length-1, A保持不动
        最后取两种情况下的最大长度
        */
        return Math.max(helper(A,B), helper(B,A));

    }
    //A从[0,A.length-1], B每次都从0开始匹配A, 返回最长的匹配长度
    private int helper(int[] A, int[] B){
        int lenA = A.length;
        int lenB = B.length;
        int maxDp = 0;
        for(int i=0; i<lenA; i++){
            //当前轮次匹配长度
            int curDp = 0;
            //A[]从i开始
            int p1 = i;
            //B[]从0开始
            int p2 = 0;
            //保证下标不越界
            while(p1<lenA && p2<lenB){
                //相等就长度+1
                if(A[p1]==B[p2]){
                    curDp++;
                }else{
                    //否则从0开始
                    curDp = 0;
                }
                //更新最长匹配长度
                maxDp = Math.max(curDp, maxDp);
                //两个指针同时后移
                p1++;
                p2++;
            }
        }
        return maxDp;
    }
}

class LC718_M2{
    /* 二维dp
    dp状态定义
        dp[i][j] = A[i:] B[j:]开始的最长公共子串长度
    转移方程
        dp[i][j] = A[i]==B[j]? dp[i+1][j+1]+1:0
     */
    public int findLength(int[] A, int[] B){
        int a = A.length;
        int b = B.length;
        //多加一列, 判断初始的情况不需要判断
        int[][] dp = new int[a+1][b+1];
        int maxLen = 0;
        //因为每次的情况与后面的情况有关, 从后往前遍历
        for(int i=a-1; i>=0; i--){
            for(int j=b-1; j>=0; j--){
                dp[i][j] = A[i]==B[j]?dp[i+1][j+1]+1:0;
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;

    }
}





































